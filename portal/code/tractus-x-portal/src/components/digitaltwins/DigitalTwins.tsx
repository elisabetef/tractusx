// Copyright (c) 2021 T-Systems
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

import { Dropdown, IContextualMenuItem, IDropdownOption, IDropdownStyles, PrimaryButton, SearchBox } from '@fluentui/react';
import * as React from 'react';
import { Link } from 'react-router-dom';
import ErrorMessage from '../ErrorMessage';
import DescriptionList from '../lists/descriptionlist';
import Loading from '../loading';
import HelpContextMenu from '../navigation/HelpContextMenu/HelpContextMenu';
import ListCountSelector from '../navigation/ListCountSelector';
import Pagination from '../navigation/Pagination';
import { DigitalTwin, getTwins } from './data';

const defaultPage = 0;
const defaultPageSize = 10;

export default class DigitalTwins extends React.Component<DigitalTwin, any>{

  constructor(props) {
    super(props);
    this.state = { 
      twins: null,
      filterParams: new URLSearchParams(`page=${defaultPage}&pageSize=${defaultPageSize}`),
      error: null,
      searchInput: '',
      manufacturer: '',
      currentPage: defaultPage,
      pageSize: defaultPageSize,
      totalPages: 1
    };

    this.onClearFilter = this.onClearFilter.bind(this);
    this.onSearchChange = this.onSearchChange.bind(this);
    this.onSearchClear = this.onSearchClear.bind(this);
    this.onDropdownChange = this.onDropdownChange.bind(this);
    this.onItemCountClick = this.onItemCountClick.bind(this);
    this.onPageBefore = this.onPageBefore.bind(this);
    this.onPageNext = this.onPageNext.bind(this);
  }

  componentDidMount() {
    this.setTwins();
  }

  componentDidUpdate(prevProps, prevState){
    if (this.state.filterParams !== prevState.filterParams) {
      this.setTwins();
    }
  }

  setTwins(){
    getTwins(this.state.filterParams)
      .then(
        twins => {
          this.setState({
            twins: twins.items, 
            pageSize: twins.itemCount,
            totalPages: twins.totalPages
          });
        },
        error => this.setState({error: error.message})
      );
  }

  setFilter(...params: { name: string, value: any }[]){
    let currentFilter = new URLSearchParams(this.state.filterParams);
    params.map(param => {
      if(currentFilter.has(param.name)){
        currentFilter.set(param.name, param.value);
      } else {
        currentFilter.append(param.name, param.value);
      }
      return null;
    })
    this.setState({filterParams: currentFilter});
  }

  onClearFilter() {
    this.doSearch('', '');
  }

  onSearchChange(value){
    this.setState({searchInput: value});
    this.doSearch(value, this.state.manufacturer);
  }

  onSearchClear(){
    this.doSearch('', this.state.manufacturer);
  }

  doSearch(searchInput, manufacturer) {
    const filteredTwins = this.state.twins.filter(twin => twin.manufacturer.includes(manufacturer) && (twin.description.includes(searchInput) || twin.localIdentifiers.some(key => key.value.includes(searchInput))));
    this.setState({searchInput: searchInput, manufacturer: manufacturer, twins: filteredTwins});
  }

  onDropdownChange(ev, option){
    this.doSearch(this.state.searchInput, option.key);
  }

  onItemCountClick(count: number){
    console.log('onItemCountClick');
    this.setState({pageSize: count}, () => this.setFilter({name: 'pageSize', value: count}));
  }

  onPageBefore(){
    this.setState({currentPage: this.state.currentPage - 1}, () => this.updatePageFilter());
  }

  onPageNext(){
    this.setState({currentPage: this.state.currentPage + 1}, () => this.updatePageFilter());
  }

  updatePageFilter(){
    this.setFilter({name: 'page', value: this.state.currentPage});
  }

  public render() {
    const helpMenuItems: IContextualMenuItem[] = [
      {
        key: 'digitwin',
        text: 'Documentation',
        href: 'https://confluence.catena-x.net/display/ARTI/Digital+Twin+Registry',
        target: '_blank',
      },
      {
        key: 'faq',
        text: 'FAQ',
        href: 'https://confluence.catena-x.net/display/ARTI/FAQ',
        target: '_blank',
      },
    ];
    const dropdownStyles: Partial<IDropdownStyles> = {
      dropdown: { width: 150, marginRight: 20 },
    };
    const manufacturerOptions: IDropdownOption[] = [
      { key: '', text: 'All' },
      { key: 'BMW', text: 'BMW' },
      { key: 'BOSCH', text: 'Bosch' },
      { key: 'T-Systems', text: 'T-Systems' },
      { key: 'SAMSUNG', text: 'Samsung' },
      { key: 'ZF', text: 'ZF' }
    ];
    return (
      <div className='p44 df fdc'>
        <HelpContextMenu menuItems={helpMenuItems}></HelpContextMenu>
        {this.state.twins ?
          <div>
            <h1 className="fs24 bold mb20">Digital Twins</h1>
            <div className="df aife jcfe mb20">
              <Dropdown placeholder="Filter"
                selectedKey={this.state.manufacturer}
                label="Twin Manufacturer"
                options={manufacturerOptions}
                styles={dropdownStyles}
                onChange={this.onDropdownChange}
              />
              <SearchBox className="w300"
                placeholder="Filter ID or description"
                value={this.state.searchInput}
                onClear={this.onSearchClear}
                onChange={(_, newValue) => this.onSearchChange(newValue)}/>
            </div>
            {this.state.twins.length > 0 ?
              <>
                <ListCountSelector activeCount={this.state.pageSize} onCountClick={this.onItemCountClick}/>
                <div className="df fwrap">
                  {this.state.twins.map(twin => (
                    <Link key={twin.id} className="m5 p20 bgpanel flex40 br4 bsdatacatalog tdn" to={{
                      pathname: `/home/digitaltwin/${twin.id}`
                    }}>
                      <h2 className='fs24 fg191 bold mb20'>{twin.description}</h2>
                      <DescriptionList title="Manufacturer:" description={twin.manufacturer}/>
                      <DescriptionList title="Aspects count:" description={twin.aspects.length}/>
                      <DescriptionList title="local Identifiers count:" description={twin.localIdentifiers.length}/>
                    </Link>
                  ))}
                  <Pagination pageNumber={this.state.currentPage + 1}
                    onPageBefore={this.onPageBefore}
                    onPageNext={this.onPageNext}
                    totalPages={this.state.totalPages}>
                  </Pagination>
                </div>
              </> :
              <div className="df fdc aic">
                <span className="fs20">No matches found!</span>
                <PrimaryButton text='Reset Filter' className="mt20" onClick={this.onClearFilter} />
            </div>
            } 
          </div> :
        <div className="h100pc df jcc">
          {this.state.error ? <ErrorMessage error={this.state.error} /> : <Loading />}
        </div>
      }
      </div>
    );
  }
}
