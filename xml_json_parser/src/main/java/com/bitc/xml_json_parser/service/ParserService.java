package com.bitc.xml_json_parser.service;

import com.bitc.xml_json_parser.DTO.PharmacyFullDataItemDTO;

import java.util.List;

public interface ParserService {
    List<PharmacyFullDataItemDTO> getItemListFile(String filePath) throws Exception;


    List<PharmacyFullDataItemDTO> getItemListUrl(String url) throws Exception;
}