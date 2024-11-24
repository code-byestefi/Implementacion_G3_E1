package com.ppai.ppai_version_2.entities;

import java.sql.Date;
import java.util.List;

public interface IEstrategia {
    List<List<Object>> buscarVinosConResenia(java.util.Date fechaDesde,java.util.Date fechaHasta,List<Vino> vinos);
}

