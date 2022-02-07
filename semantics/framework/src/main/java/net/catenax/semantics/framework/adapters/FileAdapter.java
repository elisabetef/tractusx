/*
Copyright (c) 2021-2022 T-Systems International GmbH (Catena-X Consortium)
See the AUTHORS file(s) distributed with this work for additional
information regarding authorship.

See the LICENSE file(s) distributed with this work for
additional information regarding license terms.
*/
package net.catenax.semantics.framework.adapters;

import net.catenax.semantics.framework.*;
import net.catenax.semantics.framework.config.*;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URL;

/**
 * An adapter sitting on a URL-based filesystem
 * May either point to a single file or to a directory
 * containing (parameter-indexed) files.
 */
@Service
public class FileAdapter
    extends BaseAdapter<Command, Offer, Catalog, Contract, Transformation> implements BackendAdapter {

    @Override
    public String getProtocol() {
        return "FILE";
    }

    public FileAdapter(ConfigurationData<Command,Offer,Catalog,Contract,Transformation> configurationData) {
        super(configurationData);
    }

    @Override
    public IdsMessage perform(IdsRequest request) throws StatusException {
        String file = request.getParameters().get("file");
        String model = request.getParameters().get("model");
        String command = request.getCommand();
        if(configurationData.getCommands().containsKey(command)) {
            Command co = configurationData.getCommands().get(command);
            file=co.getFile();
            model=co.getModel();
        }

        log.info("Accessing FILE source "+file+ " under assumed model "+model);

        BaseIdsMessage response = new BaseIdsMessage();

        if(file.endsWith("xml")) {
            response.setMediaType("text/xml");
        } else if (file.endsWith("json")) {
            response.setMediaType("application/json");
        }
        response.setModel(model);

        URL resource = getClass().getClassLoader().getResource(file);
        try (BufferedReader resourceStream=new BufferedReader(new InputStreamReader(resource.openStream()))) {
            StringBuilder contentBuilder = new StringBuilder();
            String sCurrentLine;
            while ((sCurrentLine = resourceStream.readLine()) != null)
            {
                contentBuilder.append(sCurrentLine).append("\n");
            }
            response.setPayload(contentBuilder.toString());
        } catch (IOException e) {
            throw new StatusException("download & transform error.", e);
        }
        return response;
    }
}
