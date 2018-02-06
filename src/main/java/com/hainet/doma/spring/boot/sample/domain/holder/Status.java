package com.hainet.doma.spring.boot.sample.domain.holder;

import lombok.RequiredArgsConstructor;
import org.seasar.doma.Domain;

@Domain(valueType = Integer.class, factoryMethod = "of")
@RequiredArgsConstructor
public enum Status {

    ACTIVE(0),
    DORMANT(1),
    SUSPEND(2);

    private final Integer value;

    public Integer getValue() {
        return this.value;
    }

    public static Status of(final Integer value) {
        for (final Status status : Status.values()) {
            if (status.getValue().equals(value)) {
                return status;
            }
        }

        throw new RuntimeException();
    }
}
