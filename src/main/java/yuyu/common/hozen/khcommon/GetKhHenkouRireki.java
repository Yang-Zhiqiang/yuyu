package yuyu.common.hozen.khcommon;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.CurrencyType;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.IT_KhHenkouRireki;
import yuyu.def.db.entity.IT_KhSisuurendoTmttkn;

/**
 * 契約保全 契約保全共通 契約保全変更履歴取得
 */
public class GetKhHenkouRireki {

    private static final String KUGIRIMOJIRETUSHASEN = "／";

    private static final String KUGIRIMOJIRETUKORON = "：";

    @Inject
    private static Logger logger;

    public GetKhHenkouRireki() {
        super();
    }

    public GetKhSisuurendoTmttknTblBean getKhSisuurendoTmttknTblSakujyo(GetKhSisuurendoTmttknTblSakujyoBean pGetKhSisuurendoTmttknTblSakujyoBean) {

        logger.debug("▽ 契約保全変更履歴取得 開始");

        if (pGetKhSisuurendoTmttknTblSakujyoBean.getKhHenkouRireki() == null) {

            logger.debug("△ 契約保全変更履歴取得 終了");

            return null;
        }

        if (BizUtil.isBlank(pGetKhSisuurendoTmttknTblSakujyoBean.getKhHenkouRireki().getBfrnaiyou())) {

            logger.debug("△ 契約保全変更履歴取得 終了");

            return null;
        }

        GetKhSisuurendoTmttknTblBean getKhSisuurendoTmttknTblBean = SWAKInjector.getInstance(GetKhSisuurendoTmttknTblBean.class);

        IT_KhHenkouRireki khHenkouRireki = pGetKhSisuurendoTmttknTblSakujyoBean.getKhHenkouRireki();

        List<String> bfrnaiyouList = new ArrayList<String>();
        List<String> tmttknTaisyouYmList = new ArrayList<String>();
        List<String> rennoList = new ArrayList<String>();
        List<String> tmttknKouryokuKaisiYmdList = new ArrayList<String>();
        List<String> teiriTutmttknGkList = new ArrayList<String>();
        List<String> sisuuRendouTmttknGkList = new ArrayList<String>();
        List<String> sisuuUprituList = new ArrayList<String>();
        List<String> tmttknZoukarituList = new ArrayList<String>();
        List<String> tmttknHaneitmmsHanteiYmdList = new ArrayList<String>();
        List<String> tmttknHaneiSisuuList = new ArrayList<String>();
        List<String> itenmaeTeirituTmttknGkList = new ArrayList<String>();
        List<String> itenmaeSisuuRendouTmttknGkList = new ArrayList<String>();
        List<String> tuukaSyuList = new ArrayList<String>();
        String bfrnaiyou = khHenkouRireki.getBfrnaiyou();

        bfrnaiyouList = Arrays.asList(bfrnaiyou.split(KUGIRIMOJIRETUSHASEN));

        tmttknTaisyouYmList = Arrays.asList(bfrnaiyouList.get(0).split(KUGIRIMOJIRETUKORON));
        rennoList = Arrays.asList(bfrnaiyouList.get(1).split(KUGIRIMOJIRETUKORON));
        tmttknKouryokuKaisiYmdList = Arrays.asList(bfrnaiyouList.get(2).split(KUGIRIMOJIRETUKORON));
        teiriTutmttknGkList = Arrays.asList(bfrnaiyouList.get(3).split(KUGIRIMOJIRETUKORON));
        sisuuRendouTmttknGkList = Arrays.asList(bfrnaiyouList.get(4).split(KUGIRIMOJIRETUKORON));
        sisuuUprituList = Arrays.asList(bfrnaiyouList.get(5).split(KUGIRIMOJIRETUKORON));
        tmttknZoukarituList = Arrays.asList(bfrnaiyouList.get(6).split(KUGIRIMOJIRETUKORON));
        tmttknHaneitmmsHanteiYmdList = Arrays.asList(bfrnaiyouList.get(7).split(KUGIRIMOJIRETUKORON));
        tmttknHaneiSisuuList = Arrays.asList(bfrnaiyouList.get(8).split(KUGIRIMOJIRETUKORON));
        itenmaeTeirituTmttknGkList = Arrays.asList(bfrnaiyouList.get(9).split(KUGIRIMOJIRETUKORON));
        itenmaeSisuuRendouTmttknGkList = Arrays.asList(bfrnaiyouList.get(10).split(KUGIRIMOJIRETUKORON));
        tuukaSyuList = Arrays.asList(bfrnaiyouList.get(11).split(KUGIRIMOJIRETUKORON));

        String tmttknTaisyouYm = tmttknTaisyouYmList.get(1);
        String renno = rennoList.get(1);
        String tmttknKouryokuKaisiYmd = tmttknKouryokuKaisiYmdList.get(1);
        String teiriTutmttknGk = teiriTutmttknGkList.get(1);
        String sisuuRendouTmttknGk = sisuuRendouTmttknGkList.get(1);
        String sisuuUpritu = sisuuUprituList.get(1);
        String tmttknZoukaritu = tmttknZoukarituList.get(1);
        String tmttknHaneitmmsHanteiYmd = tmttknHaneitmmsHanteiYmdList.get(1);
        String tmttknHaneiSisuu = tmttknHaneiSisuuList.get(1);
        String itenmaeTeirituTmttknGk = itenmaeTeirituTmttknGkList.get(1);
        String itenmaeSisuuRendouTmttknGk = itenmaeSisuuRendouTmttknGkList.get(1);
        C_Tuukasyu tuukaSyu = C_Tuukasyu.valueOf(tuukaSyuList.get(1));

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

        CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(tuukaSyu);

        IT_KhSisuurendoTmttkn khSisuurendoTmttkn = new IT_KhSisuurendoTmttkn();

        khSisuurendoTmttkn.setKbnkey(khHenkouRireki.getKbnkey());
        khSisuurendoTmttkn.setSyono(khHenkouRireki.getSyono());
        khSisuurendoTmttkn.setTmttkntaisyouym(BizDateYM.valueOf(tmttknTaisyouYm));
        khSisuurendoTmttkn.setRenno(Integer.parseInt(renno));
        khSisuurendoTmttkn.setTmttknkouryokukaisiymd(BizDate.valueOf(tmttknKouryokuKaisiYmd));
        khSisuurendoTmttkn.setTeiritutmttkngk(BizCurrency.valueOf(new BigDecimal(teiriTutmttknGk), currencyType));
        khSisuurendoTmttkn.setSisuurendoutmttkngk(BizCurrency.valueOf(new BigDecimal(sisuuRendouTmttknGk), currencyType));
        khSisuurendoTmttkn.setSisuuupritu(BizNumber.valueOf(new BigDecimal(sisuuUpritu)));
        khSisuurendoTmttkn.setTmttknzoukaritu(BizNumber.valueOf(new BigDecimal(tmttknZoukaritu)));
        if (!"null".equals(tmttknHaneitmmsHanteiYmd)) {
            khSisuurendoTmttkn.setTmttknhaneitmmshanteiymd(BizDate.valueOf(tmttknHaneitmmsHanteiYmd));
        }
        khSisuurendoTmttkn.setTmttknhaneisisuu(BizNumber.valueOf(new BigDecimal(tmttknHaneiSisuu)));
        khSisuurendoTmttkn.setGyoumuKousinKinou("init");
        khSisuurendoTmttkn.setGyoumuKousinsyaId("init");
        khSisuurendoTmttkn.setGyoumuKousinTime("0");
        khSisuurendoTmttkn.setItenmaeteiritutmttkngk(BizCurrency.valueOf(new BigDecimal(itenmaeTeirituTmttknGk), currencyType));
        khSisuurendoTmttkn.setItenmaesisuurendoutmttkngk(BizCurrency.valueOf(new BigDecimal(itenmaeSisuuRendouTmttknGk), currencyType));

        getKhSisuurendoTmttknTblBean.setKhSisuurendoTmttkn(khSisuurendoTmttkn);

        logger.debug("△ 契約保全変更履歴取得 終了");

        return getKhSisuurendoTmttknTblBean;
    }
}
