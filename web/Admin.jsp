<%@ page import="com.oeinetwork.GlobalService" %>
<%@ page import="com.oeinetwork.Verify.LoginVerify" %>
<%@ page import="java.security.NoSuchAlgorithmException" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String encrypt = "";
    String userInput = request.getParameter("entryCode");
    if (userInput == null || userInput.equals("")) {
        response.sendRedirect("/index.jsp");
    } else {
        try {
            encrypt = LoginVerify.generateMD5(LoginVerify.generateMD5(userInput));
            if (!encrypt.equals(GlobalService.key_ring)) {
                response.sendRedirect("/index.jsp");
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
%>
<head>
    <meta charset="utf-8">
    <title>控制台</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,400,600"
          rel="stylesheet">
    <link href="css/font-awesome.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <link href="css/pages/dashboard.css" rel="stylesheet">
    <link href="css/bootstrap-responsive.min.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script type="javascript">
        /*
         HTML5 Shiv v3.7.0 | @afarkas @jdalton @jon_neal @rem | MIT/GPL2 Licensed
         */
        (function (l, f) {
            function m() {
                var a = e.elements;
                return "string" == typeof a ? a.split(" ") : a
            }

            function i(a) {
                var b = n[a[o]];
                b || (b = {}, h++, a[o] = h, n[h] = b);
                return b
            }

            function p(a, b, c) {
                b || (b = f);
                if (g)return b.createElement(a);
                c || (c = i(b));
                b = c.cache[a] ? c.cache[a].cloneNode() : r.test(a) ? (c.cache[a] = c.createElem(a)).cloneNode() : c.createElem(a);
                return b.canHaveChildren && !s.test(a) ? c.frag.appendChild(b) : b
            }

            function t(a, b) {
                if (!b.cache)b.cache = {}, b.createElem = a.createElement, b.createFrag = a.createDocumentFragment, b.frag = b.createFrag();
                a.createElement = function (c) {
                    return !e.shivMethods ? b.createElem(c) : p(c, a, b)
                };
                a.createDocumentFragment = Function("h,f", "return function(){var n=f.cloneNode(),c=n.createElement;h.shivMethods&&(" + m().join().replace(/[\w\-]+/g, function (a) {
                            b.createElem(a);
                            b.frag.createElement(a);
                            return 'c("' + a + '")'
                        }) + ");return n}")(e, b.frag)
            }

            function q(a) {
                a || (a = f);
                var b = i(a);
                if (e.shivCSS && !j && !b.hasCSS) {
                    var c, d = a;
                    c = d.createElement("p");
                    d = d.getElementsByTagName("head")[0] || d.documentElement;
                    c.innerHTML = "x<style>article,aside,dialog,figcaption,figure,footer,header,hgroup,main,nav,section{display:block}mark{background:#FF0;color:#000}template{display:none}</style>";
                    c = d.insertBefore(c.lastChild, d.firstChild);
                    b.hasCSS = !!c
                }
                g || t(a, b);
                return a
            }

            var k = l.html5 || {}, s = /^<|^(?:button|map|select|textarea|object|iframe|option|optgroup)$/i, r = /^(?:a|b|code|div|fieldset|h1|h2|h3|h4|h5|h6|i|label|li|ol|p|q|span|strong|style|table|tbody|td|th|tr|ul)$/i, j, o = "_html5shiv", h = 0, n = {}, g;
            (function () {
                try {
                    var a = f.createElement("a");
                    a.innerHTML = "<xyz></xyz>";
                    j = "hidden"in a;
                    var b;
                    if (!(b = 1 == a.childNodes.length)) {
                        f.createElement("a");
                        var c = f.createDocumentFragment();
                        b = "undefined" == typeof c.cloneNode ||
                                "undefined" == typeof c.createDocumentFragment || "undefined" == typeof c.createElement
                    }
                    g = b
                } catch (d) {
                    g = j = !0
                }
            })();
            var e = {
                elements: k.elements || "abbr article aside audio bdi canvas data datalist details dialog figcaption figure footer header hgroup main mark meter nav output progress section summary template time video",
                version: "3.7.0",
                shivCSS: !1 !== k.shivCSS,
                supportsUnknownElements: g,
                shivMethods: !1 !== k.shivMethods,
                type: "default",
                shivDocument: q,
                createElement: p,
                createDocumentFragment: function (a, b) {
                    a || (a = f);
                    if (g)return a.createDocumentFragment();
                    for (var b = b || i(a), c = b.frag.cloneNode(), d = 0, e = m(), h = e.length; d < h; d++)c.createElement(e[d]);
                    return c
                }
            };
            l.html5 = e;
            q(f)
        })(this, document);
    </script>
    <![endif]-->
</head>
<body>
<div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container"><a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"><span
                class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span> </a><a
                class="brand" href="#">OEINetwork</a>
        </div>
    </div>
</div>
<div class="subnavbar">
    <div class="subnavbar-inner">
        <div class="container">
            <ul class="mainnav">
                <li class="active"><a href="#"><i class="icon-dashboard"></i><span>功能表</span> </a></li>
                <li class="dropdown"><a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown"> <i
                        class="icon-long-arrow-down"></i><span>更多</span> <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="index.jsp">退出</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</div>
<div class="main">
    <div class="main-inner">
        <div class="container">
            <div class="row">
                <div class="span6">
                    <div class="widget">
                        <div class="widget-header"><i class="icon-bookmark"></i>

                            <h3>功能选择</h3>
                        </div>
                        <div class="widget-content">
                            <div class="shortcuts"><a
                                    href="${pageContext.request.contextPath}/Admin.jsp/save.action?encryptInput=<%=encrypt %>"
                                    class="shortcut" target="_blank"><i
                                    class="shortcut-icon icon-list-alt"></i><span
                                    class="shortcut-label">导出word总汇</span> </a>
                                <a href="${pageContext.request.contextPath}/Admin.jsp/xls.action?encryptInput=<%=encrypt %>"
                                   class="shortcut" target="_blank"><i
                                        class="shortcut-icon icon-bookmark"></i><span
                                        class="shortcut-label">Excel导出</span> </a>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="js/jquery-1.7.2.min.js"></script>
<script src="js/excanvas.min.js"></script>
<script src="js/bootstrap_o.js"></script>
<script src="js/base.js"></script>
</body>
</html>
