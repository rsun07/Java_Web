package pers.xiaoming.javaweb;

enum Config {
    MYSERVLET("MyServlet"),
    MYSERVLET_WITH_CONFIG("MyServletWithConfig"),
    MYFILTER_FOR_SERVLET("MyFilterForServlet"),
    MYFILTER_URL_PATTERN("MyFilterURLPattern"),
    MY_REQUEST_LISTENER("MyRequestListener");


    private static final String CLASS_PATH = "pers.xiaoming.javaweb.";
    private static final String URL_PATH = "/dynamic/";

    private String name;
    private String classPath;
    private String urlPattern;

    Config(String name) {
        this.name = name;
        this.classPath = CLASS_PATH + name;
        this.urlPattern = URL_PATH + name.toLowerCase();
    }

    public String getName() {
        return name;
    }

    public String getClassPath() {
        return classPath;
    }

    public String getUrlPattern() {
        return urlPattern;
    }
}
