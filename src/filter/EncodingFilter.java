package filter;

/**
 * @class: EncodingFilter
 * @author: MengLei
 * @Create Date:2018-12-06.
 */

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class EncodingFilter implements Filter {
    @Override
    public void destroy() {
    }
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        // 设置编码格式为 UTF-8
        request.setCharacterEncoding("UTF-8");

        chain.doFilter(request, response);
    }
    @Override
    public void init(FilterConfig config) throws ServletException {
    }

}