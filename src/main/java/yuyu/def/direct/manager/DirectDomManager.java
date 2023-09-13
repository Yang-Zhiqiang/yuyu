package yuyu.def.direct.manager;

import java.util.List;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import yuyu.def.base.manager.DomManager;
import yuyu.def.classification.C_DsKrHnnKakCdTtYhKbn;
import yuyu.def.classification.C_DsKzkJmKknHsJyKbn;
import yuyu.def.classification.C_DsSousinMailSyubetuKbn;
import yuyu.def.classification.C_DsTtdksyubetuKbn;
import yuyu.def.db.entity.MT_BAK_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsHanyouKokyakuateTuuti;
import yuyu.def.db.entity.MT_DsHonninKakuninCd;
import yuyu.def.db.entity.MT_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsKokyakuKeiyaku;
import yuyu.def.db.entity.MT_DsKouzokuJimuKakunin;
import yuyu.def.db.entity.MT_DsMailAddressSpiralYyk;
import yuyu.def.db.entity.MT_DsMailHaisin;
import yuyu.def.db.entity.MT_DsMailHaisinYoyaku;
import yuyu.def.db.entity.MT_DsNeugokiHanteiKekka;
import yuyu.def.db.entity.MT_DsTourokuUkKanri;
import yuyu.def.db.entity.MT_KhHenkouUktkYyk;
import yuyu.def.db.entity.MT_SousaRireki;
import yuyu.def.db.entity.MW_DsMailHaisinRirekiWk;
import yuyu.def.db.entity.MW_DsNeugokiHanteiKekkaWk;
import yuyu.def.direct.result.bean.DsKokKnrInfosByDskrhnnkakcdttyhkbnSyoriYmdBean;
import yuyu.def.direct.result.bean.DsKokyakuInfoBySyonoDskykmukouhyjROWNUMBean;
import yuyu.def.direct.result.bean.DsKokyakuKanrisByItemsBean;


/**
 * ダイレクトサービス DOM マネージャ インターフェース<br />
 * カテゴリDomマネージャを業務機能から隠蔽するために、抽象クラスと実装クラスに分離して、<br />
 * 業務機能からは見えない実装クラスで、カテゴリDomマネージャを使用しています。 <br />
 */
public interface DirectDomManager extends DomManager {

    List<MT_DsKokyakuKanri> getAllDsKokyakuKanri();

    MT_DsKokyakuKanri getDsKokyakuKanri(String pDskokno);

    List<MT_DsKokyakuKeiyaku> getDsKokyakuKeiyakusBySyonoDskykmukouhyjBlank(String pSyono);

    List<MT_DsKokyakuKeiyaku> getDsKokyakuKeiyakusBySyono(String pSyono);

    ExDBUpdatableResults<MT_DsKokyakuKanri>  getDsKokyakuKanrisByKakutyoujobcdDskokyakujtkbnSeisahuyouhyjDskykmukouhyj(String pKakutyoujobcd);

    List<MT_BAK_DsKokyakuKanri> getAllBAKDsKokyakuKanri();

    MT_BAK_DsKokyakuKanri getBAKDsKokyakuKanri(String pDskokno, String pTrkssikibetukey);

    ExDBUpdatableResults<MT_DsKokyakuKanri> getDsKokyakuKanrisByKakutyoujobcd(String pKakutyoujobcd);

    List<MT_DsKokyakuKeiyaku> getDsKokyakuKeiyakusByDskoknoDskykmukouhyjSyutkkbnYuukousyoumetukbn(String pDskokno);

    ExDBUpdatableResults<MT_DsKokyakuKanri> getDsKokyakuKanrisByDskokyakujtkbnDsteisiriyuukbnDskrhnnkakcdsetymd();

    ExDBUpdatableResults<MT_DsKokyakuKanri> getDsKokyakuKanrisByDskrhnnkakcdttyhkbnDskrhnnkakcdttshjyhsymd(C_DsKrHnnKakCdTtYhKbn pDskrhnnkakcdttyhkbn, BizDate pDskrhnnkakcdttshjyhsymd);

    List<MT_DsKokyakuKanri> getDsKokyakuKanrisBySyono(String pSyono);

    List<DsKokyakuKanrisByItemsBean> getDsKokyakuKanrisByItems(String pDskokyakunmkn, String pDskokyakunmkj, BizDate pDskokyakuseiymd, String pDskokyakuyno);

    List<MT_DsKokyakuKanri> getDsKokyakuKanrisBySyonoDskykmukouhyj(String pSyono);

    DsKokyakuInfoBySyonoDskykmukouhyjROWNUMBean getDsKokyakuInfoBySyonoDskykmukouhyjROWNUM(String pSyono);

    List<MT_DsKokyakuKanri> getDsKokyakuKanrisByDskokyakujtkbnNe(String pDskokyakunmkn, String pDskokyakunmkj, BizDate pDskokyakuseiymd, String pDskokyakuyno);

    ExDBResults<MT_DsHanyouKokyakuateTuuti> getDsHanyouKokyakuateTuutisByDsdatasakuseiymd(BizDate pDsdatasakuseiymd);

    ExDBResults<MT_DsHonninKakuninCd> getDsHonninKakuninCdsByDskrhnnkakcdttshjyhsymd(BizDate pDskrhnnkakcdttshjyhsymd);

    ExDBResults<DsKokKnrInfosByDskrhnnkakcdttyhkbnSyoriYmdBean> getDsKokKnrInfosByDskrhnnkakcdttyhkbnSyoriYmd(BizDate pSyoriYmd);

    ExDBResults<MT_DsMailAddressSpiralYyk> getDsMailAddressSpiralYyksByDsdatasakuseiymd(BizDate pDsdatasakuseiymd);

    List<MT_DsNeugokiHanteiKekka> getAllDsNeugokiHanteiKekka();

    MT_DsNeugokiHanteiKekka getDsNeugokiHanteiKekka(BizDate pDsdatasakuseiymd, String pSyono);

    List<MT_DsMailHaisin> getAllDsMailHaisin();

    MT_DsMailHaisin getDsMailHaisin(BizDate pSousinymd, String pDskokmailaddressskbtkey, C_DsSousinMailSyubetuKbn pDssousinmailsyubetukbn
        , String pDssousinno);

    MT_DsMailHaisinYoyaku getDsMailHaisinYoyaku(String pDsmailhaisinyoyakuskbtkey);

    List<MT_DsMailHaisinYoyaku> getAllDsMailHaisinYoyaku();

    List<MT_DsKouzokuJimuKakunin> getAllDsKouzokuJimuKakunin();

    MT_DsKouzokuJimuKakunin getDsKouzokuJimuKakunin(BizDate pHasseiymd, C_DsKzkJmKknHsJyKbn pDskzkjmkknhsjykbn, String pSyono);

    ExDBResults<MT_DsKouzokuJimuKakunin> getDsKouzokuJimuKakuninsByHasseiymd(BizDate pHasseiymd);

    List<MW_DsNeugokiHanteiKekkaWk> getAllDsNeugokiHanteiKekkaWk();

    MW_DsNeugokiHanteiKekkaWk getDsNeugokiHanteiKekkaWk(BizDate pDsdatasakuseiymd, String pSyono);

    List<MW_DsMailHaisinRirekiWk> getAllDsMailHaisinRirekiWk();

    MW_DsMailHaisinRirekiWk getDsMailHaisinRirekiWk(BizDate pDsdatasakuseiymd, String pDskokno, Integer pDsmailhaisinrenban);

    List<MT_DsTourokuUkKanri> getAllDsTourokuUkKanri();

    MT_DsTourokuUkKanri getDsTourokuUkKanri(String pSyono, C_DsTtdksyubetuKbn pDsttdksyubetukbn, Integer pDatarenno);

    List<MT_KhHenkouUktkYyk> getAllKhHenkouUktkYyk();

    MT_KhHenkouUktkYyk getKhHenkouUktkYyk(String pSyono, Integer pHozenhenkouuktkrenno);

    List<MT_SousaRireki> getAllSousaRireki();

    MT_SousaRireki getSousaRireki(String pTtdksikibetuid);

}
