package com.thoughtworks.go.scm.plugin.model.requestHandlers;

import com.thoughtworks.go.scm.plugin.util.JsonUtils;
import com.thoughtworks.go.plugin.api.request.GoPluginApiRequest;
import com.thoughtworks.go.plugin.api.response.GoPluginApiResponse;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SCMViewRequestHandler implements RequestHandler {
    public static final String PLUGIN_NAME = "GitPathMaterial";

    @Override
    public GoPluginApiResponse handle(GoPluginApiRequest apiRequest) {
        Map<String, Object> response = new HashMap<>();
        response.put("displayValue", PLUGIN_NAME);
        try {
            response.put("template", IOUtils.toString(getClass().getResourceAsStream("/scm.template.html"), "UTF-8"));
            return JsonUtils.renderSuccessApiResponse(response);
        } catch (IOException e) {
            String message = String.format("Failed to find template: %s", e.getMessage());
            return JsonUtils.renderErrrorApiResponse(message);
        }
    }
}
