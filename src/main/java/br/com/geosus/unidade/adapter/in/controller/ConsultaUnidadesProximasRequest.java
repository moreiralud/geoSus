package br.com.geosus.unidade.adapter.in.controller;

public record ConsultaUnidadesProximasRequest(
        double latitude,
        double longitude,
        double raioKm
) {}
