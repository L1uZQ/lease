package com.l1uzq.lease.web.admin.custom.converter;

import com.l1uzq.lease.model.enums.BaseEnum;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.stereotype.Component;

/**
 * ClassName: StringToBaseEnumConverterFactory
 * Package: com.l1uzq.lease.web.admin.custom.converter
 * Description:
 *
 * @Author L1uZQ
 * @Create 2025/2/20 15:46
 * @Version 1.0
 */
@Component
public class StringToBaseEnumConverterFactory implements ConverterFactory<String, BaseEnum> {
    @Override
    public <T extends BaseEnum> Converter<String, T> getConverter(Class<T> targetType) {
        return new Converter<String, T>() {
            @Override
            public T convert(String code) {
                T[] enumConstants = targetType.getEnumConstants();
                for (T enumConstant : enumConstants) {
                    if(enumConstant.getCode().equals(Integer.valueOf(code))){
                        return enumConstant;
                    }
                }
                throw new IllegalArgumentException("code"+code+"非法");
            }
        };
    }
}
