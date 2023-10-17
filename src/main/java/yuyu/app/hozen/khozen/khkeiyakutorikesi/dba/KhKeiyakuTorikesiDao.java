package yuyu.app.hozen.khozen.khkeiyakutorikesi.dba;

import java.util.ArrayList;
import java.util.List;

import yuyu.def.db.entity.IT_Azukarikin;
import yuyu.def.db.entity.IT_Kariukekin;
import yuyu.def.db.entity.IT_KykKihon;

import com.google.common.collect.Collections2;

/**
 * 契約保全 契約保全 契約取消機能DAOクラス
 */
public class KhKeiyakuTorikesiDao {

    public List<IT_Azukarikin> getAzukarikinsBySyono(IT_KykKihon pKykKihon) {

        List<IT_Azukarikin> azukarikinLst = pKykKihon.getAzukarikins();

        azukarikinLst = new ArrayList<IT_Azukarikin>(Collections2.filter(azukarikinLst, new FilterAzukarikin1()));

        return azukarikinLst;
    }

    public List<IT_Kariukekin> getKariukekinsBySyono(IT_KykKihon pKykKihon) {

        List<IT_Kariukekin> kariukekinLst = pKykKihon.getKariukekins();

        kariukekinLst = new ArrayList<IT_Kariukekin>(Collections2.filter(kariukekinLst, new FilterKariukekin1()));

        return kariukekinLst;
    }
}
