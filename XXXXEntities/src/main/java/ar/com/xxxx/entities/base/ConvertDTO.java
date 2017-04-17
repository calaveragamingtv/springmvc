package ar.com.xxxx.entities.base;

public interface ConvertDTO<T> {

    T invert();
    void convert(T entity);


}
