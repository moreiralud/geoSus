package br.com.geosus.unidade.domain.entity;

public enum TipoUnidadeSaude {
    POSTO_SAUDE,
    UBS,
    UPA,
    POLICLINICA,
    HOSPITAL_GERAL,
    HOSPITAL_ESPECIALIZADO,
    UNIDADE_MISTA,
    PRONTO_SOCORRO_GERAL,
    PRONTO_SOCORRO_ESPECIALIZADO,
    UNIDADE_MOVEL,
    HOSPITAL;

    public static TipoUnidadeSaude fromString(String value) {
        return TipoUnidadeSaude.valueOf(value.trim().toUpperCase());
    }
}