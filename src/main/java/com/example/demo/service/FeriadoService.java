package com.example.demo.service;

import com.example.demo.repository.FeriadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.utils.DateUtils;

import java.sql.Timestamp;
import java.util.List;

@Service
public class FeriadoService {

    @Autowired
    private FeriadoRepository feriadoRepository;

    public FeriadoService(FeriadoRepository feriadoRepository) {
        this.feriadoRepository = feriadoRepository;
    }

    public List<Integer> getCountHolidaysMonth(Integer month) {
        Timestamp fecD = new Timestamp(DateUtils.getFirstDayMonth(month).getTimeInMillis());
        Timestamp fecH = new Timestamp(DateUtils.getLastDayMonth(month).getTimeInMillis());
        return feriadoRepository.getFeriados(fecD, fecH);
    }

    public List<String> getHolidaysMonth(Integer month) {
        Timestamp fecD = new Timestamp(DateUtils.getFirstDayMonth(month).getTimeInMillis());
        Timestamp fecH = new Timestamp(DateUtils.getLastDayMonth(month).getTimeInMillis());
        return feriadoRepository.getFormatFeriados(fecD, fecH);
    }

}
