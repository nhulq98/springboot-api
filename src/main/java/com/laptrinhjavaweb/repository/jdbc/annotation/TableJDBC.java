package com.laptrinhjavaweb.repository.jdbc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// khai báo để khi java reflection nó scan tới dòng này và nó biết đây là annotation và thực thi annotation này
@Retention(RetentionPolicy.RUNTIME)

/* khai báo Tagert để biết được cái annotation này dùng cho thèn nào: class, method, variable
 dùng cho thèn nào là sao? VD: ta muốn dùng annotaion nào đó cho class thì ta phải khai báo nó trên đầu class đó
 @Entity                ||  @Override               ||  @Column
 class buildingEntity   ||  public void finđAll()   ||  private String name;
*/
@Target(ElementType.TYPE)//With TYPE: annotation @TableJDBC is used for Class, interface (including annotation type), or enum declaration
public @interface TableJDBC {

    /**
     * (Optional) The name of the column. Defaults to
     * the property or field name.
     */
    String name() default "";
}
