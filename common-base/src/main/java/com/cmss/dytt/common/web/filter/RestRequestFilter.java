/* created by chenshi at 2019-01-30 */
package com.cmss.dytt.common.web.filter;

import com.cmss.dytt.common.web.constance.WebConstance;
import com.cmss.dytt.common.web.request.RestHttpServletRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 请求替换
 */
public class RestRequestFilter extends OncePerRequestFilter {
    public RestRequestFilter() {
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        RestHttpServletRequest request = new RestHttpServletRequest(httpServletRequest);
        String requestBody = request.getRequestBody();

        if (requestBody != null) {
            httpServletRequest.setAttribute(WebConstance.REQUEST_BODY, requestBody);
        }
        filterChain.doFilter(request, httpServletResponse);
    }
}
