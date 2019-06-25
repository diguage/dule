package com.diguage.dule;

import javax.servlet.http.HttpServletRequest;

/**
 * @author D瓜哥, https://www.diguage.com/
 * @since 2019-06-25 11:53
 */
public class ServletUtil {

    public static final int HTTP_DEFAULT_PORT = 80;
    public static final int HTTPS_DEFAULT_PORT = 443;

    /**
     * Get full url.
     *
     * @param request
     * @return
     */
    public static String getFullUrl(HttpServletRequest request) {
        return getFullServerName(request) + getFullPath(request);
    }

    /**
     * Get full server name: scheme://serverName:port.
     *
     * @param request
     * @return
     */
    public static String getFullServerName(HttpServletRequest request) {
        String scheme = request.getScheme().toLowerCase();
        int port = request.getServerPort();
        String serverName = request.getServerName();
        return scheme + "://" + serverName +
                ("http".equals(scheme) && port == HTTP_DEFAULT_PORT
                        || "https".equals(scheme) && port == HTTPS_DEFAULT_PORT ? "" : ":" + port);
    }

    /**
     * Get full path with query parameters.
     *
     * @param request
     * @return
     */
    public static String getFullPath(HttpServletRequest request) {
        return request.getRequestURI() +
                (request.getQueryString() != null ? "?" + request.getQueryString() : "");
    }
}
