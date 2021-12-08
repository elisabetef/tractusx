import { iFilteredDataOffers } from "@/common/interfaces/dataOffers/IDataOffers";

export enum ServiceUrlType {
  PROVIDER = "PROVIDER",
  CORE = "CORE",
}

export const DATA_OFFER_TABLE_HEADERS = [
  {
    text: "Title",
    align: "start",
    value: "title",
  },
  { text: "File name", value: "fileName" },
  { text: "Use cases", value: "accessControlUseCase" },
  { text: "Access control", value: "byOrganizationRole" },
  { text: "Usage control", value: "usageControl" },
  { text: "Actions", align: "end", value: "actions" },
];
