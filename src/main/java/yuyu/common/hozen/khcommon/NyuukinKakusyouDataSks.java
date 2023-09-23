package yuyu.common.hozen.khcommon;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.uniquekey.UniqueKeyGenerator;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.def.classification.C_KrkPayEasyHrkmyousiNkKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyuuryokuKbn;
import yuyu.def.db.entity.IT_NyuukinKakusyouData;

/**
 * 契約保全 契約保全共通 入金確証データ作成
 */
public class NyuukinKakusyouDataSks {

    @Inject
    private static Logger logger;

    @Inject
    private UniqueKeyGenerator uniqueKeyGenerator;

    public NyuukinKakusyouDataSks() {
        super();
    }

    public IT_NyuukinKakusyouData exec(KhozenCommonParam pKhozenCommonParam,
        NyuukinKakusyouDataSksParam pNyuukinKakusyouDataSksParam) {

        logger.debug("▽ 入金確証データ作成 開始");

        IT_NyuukinKakusyouData itNyuukinKakusyouData = new IT_NyuukinKakusyouData(uniqueKeyGenerator.generateUniqueKey(),
            pNyuukinKakusyouDataSksParam.getSyoNo());

        itNyuukinKakusyouData.setNyksyoriymd(pNyuukinKakusyouDataSksParam.getNykSyoriYmd());
        itNyuukinKakusyouData.setNyuukinkakusyounrkymd(pNyuukinKakusyouDataSksParam.getNyuukinKakusyounrkYmd());
        itNyuukinKakusyouData.setNykkeiro(pNyuukinKakusyouDataSksParam.getNykKeiro());
        itNyuukinKakusyouData.setHrkkaisuu(pNyuukinKakusyouDataSksParam.getHrkkaisuu());
        itNyuukinKakusyouData.setNyknaiyoukbn(pNyuukinKakusyouDataSksParam.getNykNaiyouKbn());
        itNyuukinKakusyouData.setIktnyuukinnumu(pNyuukinKakusyouDataSksParam.getIktNyuukinUmu());
        itNyuukinKakusyouData.setJyuutouym(pNyuukinKakusyouDataSksParam.getJyutouYm());
        itNyuukinKakusyouData.setJyutoukaisuuy(pNyuukinKakusyouDataSksParam.getJyutouKaisuuY());
        itNyuukinKakusyouData.setJyutoukaisuum(pNyuukinKakusyouDataSksParam.getJyutouKaisuuM());
        itNyuukinKakusyouData.setRsgaku(pNyuukinKakusyouDataSksParam.getRyosyuGk());
        itNyuukinKakusyouData.setRyosyuymd(pNyuukinKakusyouDataSksParam.getRyosyuYmd());
        itNyuukinKakusyouData.setDenrenno(pNyuukinKakusyouDataSksParam.getDenrenNo());
        itNyuukinKakusyouData.setEdano(pNyuukinKakusyouDataSksParam.getEdano());
        itNyuukinKakusyouData.setSuitoubumoncd(pNyuukinKakusyouDataSksParam.getSuitouBumonCd());
        itNyuukinKakusyouData.setHenkousikibetukey(pNyuukinKakusyouDataSksParam.getHenkousikibetukey());
        itNyuukinKakusyouData.setNykhouhoukbn(pNyuukinKakusyouDataSksParam.getNykhouhoukbn());
        itNyuukinKakusyouData.setTikiktbrisyuruikbn(pNyuukinKakusyouDataSksParam.getTikiktbrisyuruikbn());
        itNyuukinKakusyouData.setNykdenymd(pNyuukinKakusyouDataSksParam.getNykdenYmd());

        if (C_Nykkeiro.KZHRK.eq(pNyuukinKakusyouDataSksParam.getNykKeiro())) {
            itNyuukinKakusyouData.setKzhurikaebankcd(pNyuukinKakusyouDataSksParam.getKzHurikaeBankCd());
            itNyuukinKakusyouData.setKzhurikaesitencd(pNyuukinKakusyouDataSksParam.getKzHurikaeSitenCd());
            itNyuukinKakusyouData.setSyuudaikocd(pNyuukinKakusyouDataSksParam.getSyuudaikoCd());

        }

        if (C_Nykkeiro.BANK.eq(pNyuukinKakusyouDataSksParam.getNykKeiro())) {
            itNyuukinKakusyouData.setTabakarikanjyono(pNyuukinKakusyouDataSksParam.getTabakarikanjyono());
            itNyuukinKakusyouData.setNyuukinkakusyounrkno(String.valueOf(pNyuukinKakusyouDataSksParam.getNykSyoriYmd()));
            itNyuukinKakusyouData.setNyuuryokukbn(C_NyuuryokuKbn.HONSYAKOUZAHRKM);
            itNyuukinKakusyouData.setHrkmyousinkkbn(C_KrkPayEasyHrkmyousiNkKbn.TAISYOUGAI);
            itNyuukinKakusyouData.setSuitososhikicd(pNyuukinKakusyouDataSksParam.getSuitoSoshikiCd());
        }

        if (C_Nykkeiro.CREDIT.eq(pNyuukinKakusyouDataSksParam.getNykKeiro())) {

            itNyuukinKakusyouData.setCreditkessaiyouno(pNyuukinKakusyouDataSksParam.getCreditKessaiyouNo());
            itNyuukinKakusyouData.setCredituriageseikyuukbn(pNyuukinKakusyouDataSksParam.getCreditUriageSeikyuuKbn());
        }

        itNyuukinKakusyouData.setGyoumuKousinKinou(pKhozenCommonParam.getFunctionId());
        itNyuukinKakusyouData.setGyoumuKousinsyaId(pKhozenCommonParam.getUserID());
        itNyuukinKakusyouData.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

        BizPropertyInitializer.initialize(itNyuukinKakusyouData);

        logger.debug("△ 入金確証データ作成 終了");

        return itNyuukinKakusyouData;
    }

}
