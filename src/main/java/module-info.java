open module pl.put.poznan.transformer {
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.web;
    requires org.slf4j;
    requires spring.context;
    requires spring.beans;

    exports pl.put.poznan.transformer.data;
    exports pl.put.poznan.transformer.models;
}