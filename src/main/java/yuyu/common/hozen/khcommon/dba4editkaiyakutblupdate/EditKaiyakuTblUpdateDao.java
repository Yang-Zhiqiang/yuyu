package yuyu.common.hozen.khcommon.dba4editkaiyakutblupdate;

import java.util.ArrayList;
import java.util.List;

import yuyu.def.classification.C_HrsyuruiKbn;
import yuyu.def.classification.C_Siharaijyoutaikbn;
import yuyu.def.db.entity.IT_Azukarikin;
import yuyu.def.db.entity.IT_Kariukekin;
import yuyu.def.db.entity.IT_KhHenreikin;
import yuyu.def.db.entity.IT_KykKihon;

import com.google.common.collect.Collections2;

/**
 * 契約保全 契約保全共通 解約処理テーブル更新値編集DAOクラス
 */
public class EditKaiyakuTblUpdateDao {

    public List<IT_KhHenreikin> getKhHenreikinYendtMbrsBySyono(IT_KykKihon pKykKihon) {

        List<IT_KhHenreikin> khHenreikinList = pKykKihon.getKhHenreikins();

        List<IT_KhHenreikin> khHenreikinList2 = new ArrayList<IT_KhHenreikin>(Collections2.filter(
            khHenreikinList, new FilterKhHenreikin1(C_HrsyuruiKbn.YENDTHNKHENREI, C_Siharaijyoutaikbn.MBR)));

        return khHenreikinList2;
    }

    public List<IT_Azukarikin> getAzukarikinsBySyono(IT_KykKihon pKykKihon) {

        List<IT_Azukarikin> AzukarikinLst = new ArrayList<IT_Azukarikin>(Collections2.filter(
            pKykKihon.getAzukarikins(), new FilterAzukarikin1()));

        return AzukarikinLst;
    }

    public List<IT_Kariukekin> getKariukekinsBySyono(IT_KykKihon pKykKihon){

        List<IT_Kariukekin> KariukekinLst = new ArrayList<IT_Kariukekin>(Collections2.filter(
            pKykKihon.getKariukekins(), new FilterKariukekin1()));

        return KariukekinLst;
    }
}
