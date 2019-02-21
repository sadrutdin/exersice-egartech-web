package com.zaynukov.dev.service.product.description;

import com.zaynukov.dev.obj.jibx.ProductItem;
import com.zaynukov.dev.obj.jibx.Products;
import com.zaynukov.dev.utils.XmlUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Objects;

import static java.nio.charset.StandardCharsets.UTF_8;

@Service("productDescriptionService")
@Scope(proxyMode = ScopedProxyMode.DEFAULT)
class ProductDescriptionServiceImpl implements ProductDescriptionService {

    @Override
    public void save(List<ProductItem> productList) {
        ClassPathResource resource = new ClassPathResource("product.xml");
        try {
            File file = resource.getFile();
            Path path = file.toPath();
            if (resource.exists()) {
                Files.delete(path);
            }
            Files.createFile(path);

            String xmlAsStr = XmlUtils.marshalling(new Products(productList));

            assert xmlAsStr != null;

            Files.write(path, xmlAsStr.getBytes(UTF_8), StandardOpenOption.WRITE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ProductItem> getList() throws IOException {
        ClassPathResource resource = new ClassPathResource("product.xml");
        return Objects.requireNonNull(
                XmlUtils.unmarshalling(Products.class, resource.getInputStream())
        ).getList();
    }


}
