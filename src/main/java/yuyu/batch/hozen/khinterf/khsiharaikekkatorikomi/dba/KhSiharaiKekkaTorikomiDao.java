package yuyu.batch.hozen.khinterf.khsiharaikekkatorikomi.dba;

import java.util.ArrayList;
import java.util.List;

import yuyu.def.db.entity.IT_Azukarikin;
import yuyu.def.db.entity.IT_Kariukekin;
import yuyu.def.db.entity.IT_KykKihon;

import com.google.common.collect.Collections2;

/**
 * 契約保全 支払結果情報取込DAOクラス
 */
public class KhSiharaiKekkaTorikomiDao {


    public List<IT_Azukarikin> getAzukarikinsBySyono(IT_KykKihon pKykKihon) {

        List<IT_Azukarikin> azukarikinList = pKykKihon.getAzukarikins();

        return new ArrayList<IT_Azukarikin>(Collections2.filter(azukarikinList,
            new FilterAzukarikin1()));
    }

    public List<IT_Kariukekin> getKariukekinsBySyono(IT_KykKihon pKykKihon) {

        List<IT_Kariukekin> kariukekinList = pKykKihon.getKariukekins();

        return new ArrayList<IT_Kariukekin>(Collections2.filter(kariukekinList,
            new FilterKariukekin1()));
    }
}
