package com.bitc.board1.service;

import com.bitc.board1.dto.AreaDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {
    @Override
    public List<AreaDTO> getDistrictList(String cityName) throws Exception {
        List<AreaDTO> district = new ArrayList<AreaDTO>();

        switch (cityName) {
            case "서울":
                AreaDTO se1 = new AreaDTO();
                AreaDTO se2 = new AreaDTO();
                AreaDTO se3 = new AreaDTO();
                AreaDTO se4 = new AreaDTO();

                se1.setAreaName("강북구");
                se2.setAreaName("강남구");
                se3.setAreaName("강서구");
                se4.setAreaName("강동구");

                district.add(se1);
                district.add(se2);
                district.add(se3);
                district.add(se4);
                break;


            case "대전":

                AreaDTO dj1 = new AreaDTO();
                AreaDTO dj2 = new AreaDTO();
                AreaDTO dj3 = new AreaDTO();
                AreaDTO dj4 = new AreaDTO();

                dj1.setAreaName("동구");
                dj2.setAreaName("중구");
                dj3.setAreaName("서구");
                dj4.setAreaName("유성구");

                district.add(dj1);
                district.add(dj2);
                district.add(dj3);
                district.add(dj4);
                break;

            case "대구":
                AreaDTO dg1 = new AreaDTO();
                AreaDTO dg2 = new AreaDTO();
                AreaDTO dg3 = new AreaDTO();
                AreaDTO dg4 = new AreaDTO();

                dg1.setAreaName("달서구");
                dg2.setAreaName("달서군");
                dg3.setAreaName("수성구");
                dg4.setAreaName("중구");

                district.add(dg1);
                district.add(dg2);
                district.add(dg3);
                district.add(dg4);
                break;

            case "부산":
                AreaDTO bs1 = new AreaDTO();
                AreaDTO bs2 = new AreaDTO();
                AreaDTO bs3 = new AreaDTO();
                AreaDTO bs4 = new AreaDTO();

                bs1.setAreaName("부산진구");
                bs2.setAreaName("해운대구");
                bs3.setAreaName("동래구");
                bs4.setAreaName("영도구");

                district.add(bs1);
                district.add(bs2);
                district.add(bs3);
                district.add(bs4);
                break;
        }

        return null;
    }

    @Override
    public List<AreaDTO> getTownList(String districtName) throws Exception {
        List<AreaDTO> townList = new ArrayList<AreaDTO>();

        switch (districtName) {
            case "강북":
                AreaDTO seKb1 = new AreaDTO();
                AreaDTO seKb2 = new AreaDTO();
                AreaDTO seKb3 = new AreaDTO();
                AreaDTO seKb4 = new AreaDTO();

                seKb1.setAreaName("A동");
                seKb2.setAreaName("B동");
                seKb3.setAreaName("C동");
                seKb4.setAreaName("D동");

                townList.add(seKb1);
                townList.add(seKb2);
                townList.add(seKb3);
                townList.add(seKb4);
                break;

            case "강남":
                AreaDTO seKn1 = new AreaDTO();
                AreaDTO seKn2 = new AreaDTO();
                AreaDTO seKn3 = new AreaDTO();
                AreaDTO seKn4 = new AreaDTO();

                seKn1.setAreaName("A동");
                seKn2.setAreaName("B동");
                seKn3.setAreaName("C동");
                seKn4.setAreaName("D동");

                townList.add(seKn1);
                townList.add(seKn2);
                townList.add(seKn3);
                townList.add(seKn4);
                break;

            case "강서":
                AreaDTO seKs1 = new AreaDTO();
                AreaDTO seKs2 = new AreaDTO();
                AreaDTO seKs3 = new AreaDTO();
                AreaDTO seKs4 = new AreaDTO();

                seKs1.setAreaName("A동");
                seKs2.setAreaName("B동");
                seKs3.setAreaName("C동");
                seKs4.setAreaName("D동");

                townList.add(seKs1);
                townList.add(seKs2);
                townList.add(seKs3);
                townList.add(seKs4);
                break;

            case "강동":
                AreaDTO seKd1 = new AreaDTO();
                AreaDTO seKd2 = new AreaDTO();
                AreaDTO seKd3 = new AreaDTO();
                AreaDTO seKd4 = new AreaDTO();

                seKd1.setAreaName("A동");
                seKd2.setAreaName("B동");
                seKd3.setAreaName("C동");
                seKd4.setAreaName("D동");

                townList.add(seKd1);
                townList.add(seKd2);
                townList.add(seKd3);
                townList.add(seKd4);
                break;
        }
        return townList;
    }
}
