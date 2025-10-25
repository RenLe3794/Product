package com.example.product.paging;

import org.springframework.core.MethodParameter;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;



import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.*;

    public class PagingAndSortParamResolver implements HandlerMethodArgumentResolver {

        @Override
        public boolean supportsParameter(MethodParameter parameter) {
            return parameter.getParameterType().equals(PagingAndSortObject.class) ;
        }

        @Override
        public Object resolveArgument(MethodParameter parameter,
                                      ModelAndViewContainer mavContainer,
                                      NativeWebRequest webRequest,
                                      WebDataBinderFactory binderFactory) {
            PagingAndSortObject paging = new PagingAndSortObject();

            String page = webRequest.getParameter("page");
            String size = webRequest.getParameter("size");
            String sortField = webRequest.getParameter("sortField");
            String sortDir = webRequest.getParameter("sortDir");

            if (page != null) paging.setPage(Integer.parseInt(page));
            if (size != null) paging.setSize(Integer.parseInt(size));
            if (sortField != null) paging.setSortField(sortField);
            if (sortDir != null) paging.setSortDir(sortDir);

            return paging;

    }
}
