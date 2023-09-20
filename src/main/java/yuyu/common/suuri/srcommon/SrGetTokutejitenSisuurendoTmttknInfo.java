package yuyu.common.suuri.srcommon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.bean.BeanUtil;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.hozen.khcommon.GetKhHenkouRireki;
import yuyu.common.hozen.khcommon.GetKhSisuurendoTmttknTblBean;
import yuyu.common.hozen.khcommon.GetKhSisuurendoTmttknTblSakujyoBean;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.common.suuri.suuricommon.SrGetTokutejitenSyohnInfo;
import yuyu.common.suuri.suuricommon.TkJitenKeiyakuSyouhinBean;
import yuyu.def.classification.C_HnkSyuruiKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_TokutejitenSyoriKbn;
import yuyu.def.db.entity.IT_KhHenkouRireki;
import yuyu.def.db.entity.IT_KhSisuurendoTmttkn;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.SV_KiykSyuhnData;

import com.google.common.collect.Ordering;

/**
 * 数理 数理共通 特定時点指数連動型積立金情報取得
 */
public class SrGetTokutejitenSisuurendoTmttknInfo {

    private static final String KINOUID_TMTTKNINFOHANEI = "SrGetTokutejitenSisuurendoTmttknInfoHanei";

    private static final String KINOUID_TMTTKNINFOHANEITRKS = "SrGetTokutejitenSisuurendoTmttknInfoHaneiTrks";

    private static final String TBLID_KHSISUURENDOTMTTKN = "IT_KhSisuurendoTmttkn";

    @Inject
    private static Logger logger;

    @Inject
    private SrCommonKinouDao srCommonKinouDao;

    public SrGetTokutejitenSisuurendoTmttknInfo() {
        super();
    }

    public List<SrGetTokutejitenTmttknInfoBean> exec(String pSyono, BizDate pKijyunYmd, String pHenkouSikibetuKey, 
            List<SV_KiykSyuhnData> pSvKiykSyuhnDataLst) {

        logger.debug("▽ 特定時点指数連動型積立金情報取得 開始");

        List<IT_KhSisuurendoTmttkn> khSisuurendoTmttknList = new ArrayList<IT_KhSisuurendoTmttkn>();

        List<IT_KhSisuurendoTmttkn> khSisuurendoTmttknItijiList = new ArrayList<IT_KhSisuurendoTmttkn>();

        GetKhSisuurendoTmttknTblSakujyoBean getKhSisuurendoTmttknTblSakujyoBean =
            SWAKInjector.getInstance(GetKhSisuurendoTmttknTblSakujyoBean.class);

        IT_KhHenkouRireki khHenkouRireki = new IT_KhHenkouRireki();

        String wkKey = "";

        List<String> keyLst = new ArrayList<String>();
        
        GetKhSisuurendoTmttknTblBean getKhSisuurendoTmttknTblBean =
            SWAKInjector.getInstance(GetKhSisuurendoTmttknTblBean.class);

        int tmttknCount = 0;
        int tmttknTrksCount = 0;
        int gengakuCount = 0;
        List<SrGetTokutejitenTmttknInfoBean> srGetTokutejitenTmttknInfoBeanList = new ArrayList<SrGetTokutejitenTmttknInfoBean>();
        boolean trksFlg = false;

        List<IT_KhTtdkRireki> khTtdkRirekiList = new ArrayList<IT_KhTtdkRireki>();

        if (!BizUtil.isBlank(pHenkouSikibetuKey)) {

            khTtdkRirekiList = srCommonKinouDao
                .getKhTtdkRirekiDatasBySyonoHenkousikibetukey(pSyono, pHenkouSikibetuKey);
        }
        else {

            khTtdkRirekiList = srCommonKinouDao.getKhTtdkRirekiDatasBySyonoKijyunymd(pSyono, pKijyunYmd);
        }

        khSisuurendoTmttknList = srCommonKinouDao.getKhSisuurendoTmttknDatasBySyono(pSyono);

        khSisuurendoTmttknItijiList = createTmpList(khSisuurendoTmttknList);

        for (int i = 0; i < khTtdkRirekiList.size(); i++) {

            IT_KhTtdkRireki khTtdkRireki1 = khTtdkRirekiList.get(i);

            if (!((IKhozenCommonConstants.KINOUID_KHSISUURENDOTMTTKNHANEI.equals(khTtdkRireki1.getGyoumuKousinKinou()) &&
                C_SyoriKbn.TMTTKNHANEI.eq(khTtdkRireki1.getSyorikbn()))
                || (IKhozenCommonConstants.KINOUID_KHSISUURENDOTMTTKNHANEI.equals(khTtdkRireki1.getGyoumuKousinKinou()) &&
                    C_SyoriKbn.TMTTKNHANEI_ITEN.eq(khTtdkRireki1.getSyorikbn()))
                    || (IKhozenCommonConstants.KINOUID_KANIKEIYAKUNAIYOUTEISEI.equals(khTtdkRireki1.getGyoumuKousinKinou()) &&
                        C_SyoriKbn.TMTTKNHANEI_TORIKESI.eq(khTtdkRireki1.getSyorikbn()))
                        || (IKhozenCommonConstants.KINOUID_KANIKEIYAKUNAIYOUTEISEI.equals(khTtdkRireki1.getGyoumuKousinKinou()) &&
                            C_SyoriKbn.TMTTKNHANEI_ITEN_TORIKESI.eq(khTtdkRireki1.getSyorikbn()))
                            || IKhozenCommonConstants.KINOUID_GENGAKU.equals(khTtdkRireki1.getGyoumuKousinKinou()))) {

                continue;
            }

            if ((IKhozenCommonConstants.KINOUID_KHSISUURENDOTMTTKNHANEI.equals(khTtdkRireki1.getGyoumuKousinKinou()) &&
                C_SyoriKbn.TMTTKNHANEI.eq(khTtdkRireki1.getSyorikbn()))
                || (IKhozenCommonConstants.KINOUID_KHSISUURENDOTMTTKNHANEI.equals(khTtdkRireki1.getGyoumuKousinKinou()) &&
                    C_SyoriKbn.TMTTKNHANEI_ITEN.eq(khTtdkRireki1.getSyorikbn()))) {

                if (trksFlg) {

                    trksFlg = false;

                    continue;
                }
                tmttknCount = tmttknCount + 1;

                IT_KhSisuurendoTmttkn khSisuurendoTmttkn = getTmttknEntity(khSisuurendoTmttknItijiList,
                    IKhozenCommonConstants.KINOUID_KHSISUURENDOTMTTKNHANEI, tmttknCount);

                SrGetTokutejitenTmttknInfoBean srGetTokutejitenTmttknInfoBean = new SrGetTokutejitenTmttknInfoBean();
                srGetTokutejitenTmttknInfoBean.setKbnkey(khSisuurendoTmttkn.getKbnkey());
                srGetTokutejitenTmttknInfoBean.setSyono(khSisuurendoTmttkn.getSyono());
                srGetTokutejitenTmttknInfoBean.setTmttkntaisyouym(khSisuurendoTmttkn.getTmttkntaisyouym());
                srGetTokutejitenTmttknInfoBean.setRenno(khSisuurendoTmttkn.getRenno());
                srGetTokutejitenTmttknInfoBean
                .setTmttknkouryokukaisiymd(khSisuurendoTmttkn.getTmttknkouryokukaisiymd());
                srGetTokutejitenTmttknInfoBean.setTeiritutmttkngk(khSisuurendoTmttkn.getTeiritutmttkngk());
                srGetTokutejitenTmttknInfoBean.setSisuurendoutmttkngk(khSisuurendoTmttkn.getSisuurendoutmttkngk());
                srGetTokutejitenTmttknInfoBean.setSisuuupritu(khSisuurendoTmttkn.getSisuuupritu());
                srGetTokutejitenTmttknInfoBean.setTmttknzoukaritu(khSisuurendoTmttkn.getTmttknzoukaritu());
                srGetTokutejitenTmttknInfoBean.setTmttknhaneitmmshanteiymd(khSisuurendoTmttkn
                    .getTmttknhaneitmmshanteiymd());
                srGetTokutejitenTmttknInfoBean.setTmttknhaneisisuu(khSisuurendoTmttkn.getTmttknhaneisisuu());
                srGetTokutejitenTmttknInfoBean.setGyoumuKousinKinou(khSisuurendoTmttkn.getGyoumuKousinKinou());
                srGetTokutejitenTmttknInfoBean.setGyoumuKousinsyaId(khSisuurendoTmttkn.getGyoumuKousinsyaId());
                srGetTokutejitenTmttknInfoBean.setGyoumuKousinTime(khSisuurendoTmttkn.getGyoumuKousinTime());
                srGetTokutejitenTmttknInfoBean.setKousinsyaId(khSisuurendoTmttkn.getKousinsyaId());
                srGetTokutejitenTmttknInfoBean.setKousinTime(khSisuurendoTmttkn.getKousinTime());
                srGetTokutejitenTmttknInfoBean.setKousinKinou(khSisuurendoTmttkn.getKousinKinou());
                srGetTokutejitenTmttknInfoBean.setVersion(khSisuurendoTmttkn.getVersion());
                srGetTokutejitenTmttknInfoBean
                .setItenmaeteiritutmttkngk(khSisuurendoTmttkn.getItenmaeteiritutmttkngk());
                srGetTokutejitenTmttknInfoBean.setItenmaesisuurendoutmttkngk(khSisuurendoTmttkn
                    .getItenmaesisuurendoutmttkngk());
                srGetTokutejitenTmttknInfoBean.setHenkousikibetukey(khTtdkRireki1.getHenkousikibetukey());
                srGetTokutejitenTmttknInfoBean.setSyoriYmd(khTtdkRireki1.getSyoriYmd());

                wkKey = khSisuurendoTmttkn.getKbnkey() + khSisuurendoTmttkn.getSyono() + 
                    khSisuurendoTmttkn.getTmttkntaisyouym() + khSisuurendoTmttkn.getRenno();
                keyLst.add(wkKey);

                srGetTokutejitenTmttknInfoBeanList.add(srGetTokutejitenTmttknInfoBean);
            }
            else if ((IKhozenCommonConstants.KINOUID_KANIKEIYAKUNAIYOUTEISEI.equals(khTtdkRireki1.getGyoumuKousinKinou()) &&
                C_SyoriKbn.TMTTKNHANEI_TORIKESI.eq(khTtdkRireki1.getSyorikbn()))
                || (IKhozenCommonConstants.KINOUID_KANIKEIYAKUNAIYOUTEISEI.equals(khTtdkRireki1.getGyoumuKousinKinou()) &&
                    C_SyoriKbn.TMTTKNHANEI_ITEN_TORIKESI.eq(khTtdkRireki1.getSyorikbn()))) {

                trksFlg = true;

                khHenkouRireki = srCommonKinouDao.getKhHenkouRirekiDataBySyonoHenkousikibetukey(pSyono,
                    khTtdkRireki1.getHenkousikibetukey(), TBLID_KHSISUURENDOTMTTKN, C_HnkSyuruiKbn.SAKUJYO);

                getKhSisuurendoTmttknTblSakujyoBean.setKhHenkouRireki(khHenkouRireki);

                GetKhHenkouRireki getKhHenkouRireki = SWAKInjector.getInstance(GetKhHenkouRireki.class);

                getKhSisuurendoTmttknTblBean = getKhHenkouRireki.getKhSisuurendoTmttknTblSakujyo(
                    getKhSisuurendoTmttknTblSakujyoBean);

                tmttknTrksCount = tmttknTrksCount + 1;
                SrGetTokutejitenTmttknInfoBean srGetTokutejitenTmttknInfoBean = new SrGetTokutejitenTmttknInfoBean();
                srGetTokutejitenTmttknInfoBean.setHenkousikibetukey(khTtdkRireki1.getHenkousikibetukey());
                srGetTokutejitenTmttknInfoBean.setGyoumuKousinKinou(KINOUID_TMTTKNINFOHANEITRKS);
                srGetTokutejitenTmttknInfoBean.setSyoriYmd(khTtdkRireki1.getSyoriYmd());

                srGetTokutejitenTmttknInfoBeanList.add(srGetTokutejitenTmttknInfoBean);

                tmttknCount = tmttknCount + 1;

                IT_KhSisuurendoTmttkn khSisuurendoTmttkn = getKhSisuurendoTmttknTblBean.getKhSisuurendoTmttkn();

                srGetTokutejitenTmttknInfoBean = new SrGetTokutejitenTmttknInfoBean();
                srGetTokutejitenTmttknInfoBean.setKbnkey(khSisuurendoTmttkn.getKbnkey());
                srGetTokutejitenTmttknInfoBean.setSyono(khSisuurendoTmttkn.getSyono());
                srGetTokutejitenTmttknInfoBean.setTmttkntaisyouym(khSisuurendoTmttkn.getTmttkntaisyouym());
                srGetTokutejitenTmttknInfoBean.setRenno(khSisuurendoTmttkn.getRenno());
                srGetTokutejitenTmttknInfoBean
                .setTmttknkouryokukaisiymd(khSisuurendoTmttkn.getTmttknkouryokukaisiymd());
                srGetTokutejitenTmttknInfoBean.setTeiritutmttkngk(khSisuurendoTmttkn.getTeiritutmttkngk());
                srGetTokutejitenTmttknInfoBean.setSisuurendoutmttkngk(khSisuurendoTmttkn.getSisuurendoutmttkngk());
                srGetTokutejitenTmttknInfoBean.setSisuuupritu(khSisuurendoTmttkn.getSisuuupritu());
                srGetTokutejitenTmttknInfoBean.setTmttknzoukaritu(khSisuurendoTmttkn.getTmttknzoukaritu());
                srGetTokutejitenTmttknInfoBean.setTmttknhaneitmmshanteiymd(khSisuurendoTmttkn
                    .getTmttknhaneitmmshanteiymd());
                srGetTokutejitenTmttknInfoBean.setTmttknhaneisisuu(khSisuurendoTmttkn.getTmttknhaneisisuu());
                srGetTokutejitenTmttknInfoBean.setGyoumuKousinsyaId(khSisuurendoTmttkn.getGyoumuKousinsyaId());
                srGetTokutejitenTmttknInfoBean.setGyoumuKousinTime(khSisuurendoTmttkn.getGyoumuKousinTime());
                srGetTokutejitenTmttknInfoBean.setKousinsyaId(khSisuurendoTmttkn.getKousinsyaId());
                srGetTokutejitenTmttknInfoBean.setKousinTime(khSisuurendoTmttkn.getKousinTime());
                srGetTokutejitenTmttknInfoBean.setKousinKinou(khSisuurendoTmttkn.getKousinKinou());
                srGetTokutejitenTmttknInfoBean.setVersion(khSisuurendoTmttkn.getVersion());
                srGetTokutejitenTmttknInfoBean
                .setItenmaeteiritutmttkngk(khSisuurendoTmttkn.getItenmaeteiritutmttkngk());
                srGetTokutejitenTmttknInfoBean.setItenmaesisuurendoutmttkngk(khSisuurendoTmttkn
                    .getItenmaesisuurendoutmttkngk());
                srGetTokutejitenTmttknInfoBean.setGyoumuKousinKinou(KINOUID_TMTTKNINFOHANEI);
                srGetTokutejitenTmttknInfoBean.setSyoriYmd(khTtdkRireki1.getSyoriYmd());

                srGetTokutejitenTmttknInfoBean.setHenkousikibetukey(getNextHenkousikibetukey(khTtdkRirekiList, i));

                srGetTokutejitenTmttknInfoBeanList.add(srGetTokutejitenTmttknInfoBean);
            }

            else if (IKhozenCommonConstants.KINOUID_GENGAKU.equals(khTtdkRireki1.getGyoumuKousinKinou())) {

                SrGetTokutejitenSyohnInfo srGetTokutejitenSyohnInfo =
                    SWAKInjector.getInstance(SrGetTokutejitenSyohnInfo.class);

                TkJitenKeiyakuSyouhinBean tkJitenKeiyakuSyouhinBean = srGetTokutejitenSyohnInfo.exec(
                C_TokutejitenSyoriKbn.TOKUTEIIDOUSYOUHININFO,
                khTtdkRireki1.getSyono(),
                null,
                khTtdkRireki1.getHenkousikibetukey(),
                pSvKiykSyuhnDataLst);

                BizDate yendthnkymd = tkJitenKeiyakuSyouhinBean.getTkJitenKeiyakuSyouhinKijyunBeanAto().getYendthnkymd();
                
                if (yendthnkymd != null) {

                    continue;

                }

                gengakuCount = gengakuCount + 1;

                IT_KhSisuurendoTmttkn khSisuurendoTmttkn = getTmttknEntity(khSisuurendoTmttknItijiList,
                    IKhozenCommonConstants.KINOUID_GENGAKU, gengakuCount);

                SrGetTokutejitenTmttknInfoBean srGetTokutejitenTmttknInfoBean = new SrGetTokutejitenTmttknInfoBean();
                srGetTokutejitenTmttknInfoBean.setKbnkey(khSisuurendoTmttkn.getKbnkey());
                srGetTokutejitenTmttknInfoBean.setSyono(khSisuurendoTmttkn.getSyono());
                srGetTokutejitenTmttknInfoBean.setTmttkntaisyouym(khSisuurendoTmttkn.getTmttkntaisyouym());
                srGetTokutejitenTmttknInfoBean.setRenno(khSisuurendoTmttkn.getRenno());
                srGetTokutejitenTmttknInfoBean
                .setTmttknkouryokukaisiymd(khSisuurendoTmttkn.getTmttknkouryokukaisiymd());
                srGetTokutejitenTmttknInfoBean.setTeiritutmttkngk(khSisuurendoTmttkn.getTeiritutmttkngk());
                srGetTokutejitenTmttknInfoBean.setSisuurendoutmttkngk(khSisuurendoTmttkn.getSisuurendoutmttkngk());
                srGetTokutejitenTmttknInfoBean.setSisuuupritu(khSisuurendoTmttkn.getSisuuupritu());
                srGetTokutejitenTmttknInfoBean.setTmttknzoukaritu(khSisuurendoTmttkn.getTmttknzoukaritu());
                srGetTokutejitenTmttknInfoBean.setTmttknhaneitmmshanteiymd(khSisuurendoTmttkn
                    .getTmttknhaneitmmshanteiymd());
                srGetTokutejitenTmttknInfoBean.setTmttknhaneisisuu(khSisuurendoTmttkn.getTmttknhaneisisuu());
                srGetTokutejitenTmttknInfoBean.setGyoumuKousinKinou(khSisuurendoTmttkn.getGyoumuKousinKinou());
                srGetTokutejitenTmttknInfoBean.setGyoumuKousinsyaId(khSisuurendoTmttkn.getGyoumuKousinsyaId());
                srGetTokutejitenTmttknInfoBean.setGyoumuKousinTime(khSisuurendoTmttkn.getGyoumuKousinTime());
                srGetTokutejitenTmttknInfoBean.setKousinsyaId(khSisuurendoTmttkn.getKousinsyaId());
                srGetTokutejitenTmttknInfoBean.setKousinTime(khSisuurendoTmttkn.getKousinTime());
                srGetTokutejitenTmttknInfoBean.setKousinKinou(khSisuurendoTmttkn.getKousinKinou());
                srGetTokutejitenTmttknInfoBean.setVersion(khSisuurendoTmttkn.getVersion());
                srGetTokutejitenTmttknInfoBean
                .setItenmaeteiritutmttkngk(khSisuurendoTmttkn.getItenmaeteiritutmttkngk());
                srGetTokutejitenTmttknInfoBean.setItenmaesisuurendoutmttkngk(khSisuurendoTmttkn
                    .getItenmaesisuurendoutmttkngk());
                srGetTokutejitenTmttknInfoBean.setHenkousikibetukey(khTtdkRireki1.getHenkousikibetukey());
                srGetTokutejitenTmttknInfoBean.setSyoriYmd(khTtdkRireki1.getSyoriYmd());

                wkKey = khSisuurendoTmttkn.getKbnkey() + khSisuurendoTmttkn.getSyono() + 
                    khSisuurendoTmttkn.getTmttkntaisyouym() + khSisuurendoTmttkn.getRenno();
                keyLst.add(wkKey);

                srGetTokutejitenTmttknInfoBeanList.add(srGetTokutejitenTmttknInfoBean);

            }
        }

        for (int i = 0; i < khSisuurendoTmttknList.size(); i++) {

            IT_KhSisuurendoTmttkn khSisuurendoTmttkn = khSisuurendoTmttknList.get(i);
            wkKey = khSisuurendoTmttkn.getKbnkey() + khSisuurendoTmttkn.getSyono() + 
                    khSisuurendoTmttkn.getTmttkntaisyouym() + khSisuurendoTmttkn.getRenno();
            
            if (!keyLst.contains(wkKey)) {
                SrGetTokutejitenTmttknInfoBean srGetTokutejitenTmttknInfoBean = new SrGetTokutejitenTmttknInfoBean();
                srGetTokutejitenTmttknInfoBean.setKbnkey(khSisuurendoTmttkn.getKbnkey());
                srGetTokutejitenTmttknInfoBean.setSyono(khSisuurendoTmttkn.getSyono());
                srGetTokutejitenTmttknInfoBean.setTmttkntaisyouym(khSisuurendoTmttkn.getTmttkntaisyouym());
                srGetTokutejitenTmttknInfoBean.setRenno(khSisuurendoTmttkn.getRenno());
                srGetTokutejitenTmttknInfoBean
                .setTmttknkouryokukaisiymd(khSisuurendoTmttkn.getTmttknkouryokukaisiymd());
                srGetTokutejitenTmttknInfoBean.setTeiritutmttkngk(khSisuurendoTmttkn.getTeiritutmttkngk());
                srGetTokutejitenTmttknInfoBean.setSisuurendoutmttkngk(khSisuurendoTmttkn.getSisuurendoutmttkngk());
                srGetTokutejitenTmttknInfoBean.setSisuuupritu(khSisuurendoTmttkn.getSisuuupritu());
                srGetTokutejitenTmttknInfoBean.setTmttknzoukaritu(khSisuurendoTmttkn.getTmttknzoukaritu());
                srGetTokutejitenTmttknInfoBean.setTmttknhaneitmmshanteiymd(khSisuurendoTmttkn
                    .getTmttknhaneitmmshanteiymd());
                srGetTokutejitenTmttknInfoBean.setTmttknhaneisisuu(khSisuurendoTmttkn.getTmttknhaneisisuu());
                srGetTokutejitenTmttknInfoBean.setGyoumuKousinKinou(khSisuurendoTmttkn.getGyoumuKousinKinou());
                srGetTokutejitenTmttknInfoBean.setGyoumuKousinsyaId(khSisuurendoTmttkn.getGyoumuKousinsyaId());
                srGetTokutejitenTmttknInfoBean.setGyoumuKousinTime(khSisuurendoTmttkn.getGyoumuKousinTime());
                srGetTokutejitenTmttknInfoBean.setKousinsyaId(khSisuurendoTmttkn.getKousinsyaId());
                srGetTokutejitenTmttknInfoBean.setKousinTime(khSisuurendoTmttkn.getKousinTime());
                srGetTokutejitenTmttknInfoBean.setKousinKinou(khSisuurendoTmttkn.getKousinKinou());
                srGetTokutejitenTmttknInfoBean.setVersion(khSisuurendoTmttkn.getVersion());
                srGetTokutejitenTmttknInfoBean
                .setItenmaeteiritutmttkngk(khSisuurendoTmttkn.getItenmaeteiritutmttkngk());
                srGetTokutejitenTmttknInfoBean.setItenmaesisuurendoutmttkngk(khSisuurendoTmttkn
                    .getItenmaesisuurendoutmttkngk());

                srGetTokutejitenTmttknInfoBeanList.add(srGetTokutejitenTmttknInfoBean);
            }

        }

        setTmttknkouryokukaisiymdForComp(srGetTokutejitenTmttknInfoBeanList);
        
        Ordering<SrGetTokutejitenTmttknInfoBean> ordering = Ordering.from(new SrTmttknInfoBeanSortComparator());
        List<SrGetTokutejitenTmttknInfoBean> sortedSrGetTokutejitenTmttknInfoBeanList = new ArrayList<SrGetTokutejitenTmttknInfoBean>();
        sortedSrGetTokutejitenTmttknInfoBeanList = ordering.sortedCopy(srGetTokutejitenTmttknInfoBeanList);

        logger.debug("△ 特定時点指数連動型積立金情報取得 終了");

        return sortedSrGetTokutejitenTmttknInfoBeanList;
    }

    public KhSisuurendoTmttknBean getSisuurendoTmttknInfo(BizDate pKijyunYmd, String pHenkouSikibetuKey,
        List<SrGetTokutejitenTmttknInfoBean> pSrGetTokutejitenTmttknInfoBeanList) {

        logger.debug("▽ 検索処理 開始");

        KhSisuurendoTmttknBean khSisuurendoTmttknBean = new KhSisuurendoTmttknBean();

        if (pKijyunYmd != null && !BizUtil.isBlank(pHenkouSikibetuKey)) {

            khSisuurendoTmttknBean = getSisuurendoTmttknInfo2(pKijyunYmd, pHenkouSikibetuKey, pSrGetTokutejitenTmttknInfoBeanList);
            return khSisuurendoTmttknBean;

        }

        if (!BizUtil.isBlank(pHenkouSikibetuKey)) {

            for (int i = 0; i < pSrGetTokutejitenTmttknInfoBeanList.size(); i++) {

                SrGetTokutejitenTmttknInfoBean srGetTokutejitenTmttknInfoBean = pSrGetTokutejitenTmttknInfoBeanList.get(i);

                if (pHenkouSikibetuKey.equals(srGetTokutejitenTmttknInfoBean.getHenkousikibetukey())) {
                    if (IKhozenCommonConstants.KINOUID_KHSISUURENDOTMTTKNHANEI.equals(
                        srGetTokutejitenTmttknInfoBean.getGyoumuKousinKinou()) ||
                        KINOUID_TMTTKNINFOHANEI.equals(srGetTokutejitenTmttknInfoBean.getGyoumuKousinKinou())) {

                        IT_KhSisuurendoTmttkn khSisuurendoTmttknAto = new IT_KhSisuurendoTmttkn();

                        khSisuurendoTmttknAto.setKbnkey(srGetTokutejitenTmttknInfoBean.getKbnkey());
                        khSisuurendoTmttknAto.setSyono(srGetTokutejitenTmttknInfoBean.getSyono());
                        khSisuurendoTmttknAto.setTmttkntaisyouym(srGetTokutejitenTmttknInfoBean.getTmttkntaisyouym());
                        khSisuurendoTmttknAto.setRenno(srGetTokutejitenTmttknInfoBean.getRenno());
                        khSisuurendoTmttknAto.setTmttknkouryokukaisiymd(srGetTokutejitenTmttknInfoBean
                            .getTmttknkouryokukaisiymd());
                        khSisuurendoTmttknAto.setTeiritutmttkngk(srGetTokutejitenTmttknInfoBean.getTeiritutmttkngk());
                        khSisuurendoTmttknAto.setSisuurendoutmttkngk(srGetTokutejitenTmttknInfoBean.getSisuurendoutmttkngk());
                        khSisuurendoTmttknAto.setSisuuupritu(srGetTokutejitenTmttknInfoBean.getSisuuupritu());
                        khSisuurendoTmttknAto.setTmttknzoukaritu(srGetTokutejitenTmttknInfoBean.getTmttknzoukaritu());
                        khSisuurendoTmttknAto.setTmttknhaneitmmshanteiymd(srGetTokutejitenTmttknInfoBean
                            .getTmttknhaneitmmshanteiymd());
                        khSisuurendoTmttknAto.setTmttknhaneisisuu(srGetTokutejitenTmttknInfoBean.getTmttknhaneisisuu());
                        khSisuurendoTmttknAto.setGyoumuKousinKinou(srGetTokutejitenTmttknInfoBean.getGyoumuKousinKinou());
                        khSisuurendoTmttknAto.setGyoumuKousinsyaId(srGetTokutejitenTmttknInfoBean.getGyoumuKousinsyaId());
                        khSisuurendoTmttknAto.setGyoumuKousinTime(srGetTokutejitenTmttknInfoBean.getGyoumuKousinTime());
                        khSisuurendoTmttknAto.setKousinsyaId(srGetTokutejitenTmttknInfoBean.getKousinsyaId());
                        khSisuurendoTmttknAto.setKousinTime(srGetTokutejitenTmttknInfoBean.getKousinTime());
                        khSisuurendoTmttknAto.setKousinKinou(srGetTokutejitenTmttknInfoBean.getKousinKinou());
                        khSisuurendoTmttknAto.setVersion(srGetTokutejitenTmttknInfoBean.getVersion());
                        khSisuurendoTmttknAto.setItenmaeteiritutmttkngk(srGetTokutejitenTmttknInfoBean
                            .getItenmaeteiritutmttkngk());
                        khSisuurendoTmttknAto.setItenmaesisuurendoutmttkngk(srGetTokutejitenTmttknInfoBean
                            .getItenmaesisuurendoutmttkngk());

                        khSisuurendoTmttknBean.setKhSisuurendoTmttknAto(khSisuurendoTmttknAto);

                        SrGetTokutejitenTmttknInfoBean srGetTokutejitenTmttknInfoBeanMae = getTaiouRecord(
                            pSrGetTokutejitenTmttknInfoBeanList, i);

                        IT_KhSisuurendoTmttkn khSisuurendoTmttknMae = new IT_KhSisuurendoTmttkn();

                        khSisuurendoTmttknMae.setKbnkey(srGetTokutejitenTmttknInfoBeanMae.getKbnkey());
                        khSisuurendoTmttknMae.setSyono(srGetTokutejitenTmttknInfoBeanMae.getSyono());
                        khSisuurendoTmttknMae.setTmttkntaisyouym(srGetTokutejitenTmttknInfoBeanMae.getTmttkntaisyouym());
                        khSisuurendoTmttknMae.setRenno(srGetTokutejitenTmttknInfoBeanMae.getRenno());
                        khSisuurendoTmttknMae.setTmttknkouryokukaisiymd(srGetTokutejitenTmttknInfoBeanMae
                            .getTmttknkouryokukaisiymd());
                        khSisuurendoTmttknMae.setTeiritutmttkngk(srGetTokutejitenTmttknInfoBeanMae.getTeiritutmttkngk());
                        khSisuurendoTmttknMae.setSisuurendoutmttkngk(srGetTokutejitenTmttknInfoBeanMae.getSisuurendoutmttkngk());
                        khSisuurendoTmttknMae.setSisuuupritu(srGetTokutejitenTmttknInfoBeanMae.getSisuuupritu());
                        khSisuurendoTmttknMae.setTmttknzoukaritu(srGetTokutejitenTmttknInfoBeanMae.getTmttknzoukaritu());
                        khSisuurendoTmttknMae.setTmttknhaneitmmshanteiymd(srGetTokutejitenTmttknInfoBeanMae
                            .getTmttknhaneitmmshanteiymd());
                        khSisuurendoTmttknMae.setTmttknhaneisisuu(srGetTokutejitenTmttknInfoBeanMae.getTmttknhaneisisuu());
                        khSisuurendoTmttknMae.setGyoumuKousinKinou(srGetTokutejitenTmttknInfoBeanMae.getGyoumuKousinKinou());
                        khSisuurendoTmttknMae.setGyoumuKousinsyaId(srGetTokutejitenTmttknInfoBeanMae.getGyoumuKousinsyaId());
                        khSisuurendoTmttknMae.setGyoumuKousinTime(srGetTokutejitenTmttknInfoBeanMae.getGyoumuKousinTime());
                        khSisuurendoTmttknMae.setKousinsyaId(srGetTokutejitenTmttknInfoBeanMae.getKousinsyaId());
                        khSisuurendoTmttknMae.setKousinTime(srGetTokutejitenTmttknInfoBeanMae.getKousinTime());
                        khSisuurendoTmttknMae.setKousinKinou(srGetTokutejitenTmttknInfoBeanMae.getKousinKinou());
                        khSisuurendoTmttknMae.setVersion(srGetTokutejitenTmttknInfoBeanMae.getVersion());
                        khSisuurendoTmttknMae.setItenmaeteiritutmttkngk(srGetTokutejitenTmttknInfoBeanMae
                            .getItenmaeteiritutmttkngk());
                        khSisuurendoTmttknMae.setItenmaesisuurendoutmttkngk(srGetTokutejitenTmttknInfoBeanMae
                            .getItenmaesisuurendoutmttkngk());

                        khSisuurendoTmttknBean.setKhSisuurendoTmttknMae(khSisuurendoTmttknMae);

                        break;

                    }

                    else if (KINOUID_TMTTKNINFOHANEITRKS.equals(srGetTokutejitenTmttknInfoBean.getGyoumuKousinKinou())) {

                        SrGetTokutejitenTmttknInfoBean srGetTokutejitenTmttknInfoBeanMae =
                            pSrGetTokutejitenTmttknInfoBeanList.get(i + 1);

                        IT_KhSisuurendoTmttkn khSisuurendoTmttknMae = new IT_KhSisuurendoTmttkn();

                        khSisuurendoTmttknMae.setKbnkey(srGetTokutejitenTmttknInfoBeanMae.getKbnkey());
                        khSisuurendoTmttknMae.setSyono(srGetTokutejitenTmttknInfoBeanMae.getSyono());
                        khSisuurendoTmttknMae.setTmttkntaisyouym(srGetTokutejitenTmttknInfoBeanMae.getTmttkntaisyouym());
                        khSisuurendoTmttknMae.setRenno(srGetTokutejitenTmttknInfoBeanMae.getRenno());
                        khSisuurendoTmttknMae.setTmttknkouryokukaisiymd(srGetTokutejitenTmttknInfoBeanMae
                            .getTmttknkouryokukaisiymd());
                        khSisuurendoTmttknMae.setTeiritutmttkngk(srGetTokutejitenTmttknInfoBeanMae.getTeiritutmttkngk());
                        khSisuurendoTmttknMae.setSisuurendoutmttkngk(srGetTokutejitenTmttknInfoBeanMae
                            .getSisuurendoutmttkngk());
                        khSisuurendoTmttknMae.setSisuuupritu(srGetTokutejitenTmttknInfoBeanMae.getSisuuupritu());
                        khSisuurendoTmttknMae.setTmttknzoukaritu(srGetTokutejitenTmttknInfoBeanMae.getTmttknzoukaritu());
                        khSisuurendoTmttknMae.setTmttknhaneitmmshanteiymd(srGetTokutejitenTmttknInfoBeanMae
                            .getTmttknhaneitmmshanteiymd());
                        khSisuurendoTmttknMae.setTmttknhaneisisuu(srGetTokutejitenTmttknInfoBeanMae.getTmttknhaneisisuu());
                        khSisuurendoTmttknMae.setGyoumuKousinKinou(srGetTokutejitenTmttknInfoBeanMae.getGyoumuKousinKinou());
                        khSisuurendoTmttknMae.setGyoumuKousinsyaId(srGetTokutejitenTmttknInfoBeanMae.getGyoumuKousinsyaId());
                        khSisuurendoTmttknMae.setGyoumuKousinTime(srGetTokutejitenTmttknInfoBeanMae.getGyoumuKousinTime());
                        khSisuurendoTmttknMae.setKousinsyaId(srGetTokutejitenTmttknInfoBeanMae.getKousinsyaId());
                        khSisuurendoTmttknMae.setKousinTime(srGetTokutejitenTmttknInfoBeanMae.getKousinTime());
                        khSisuurendoTmttknMae.setKousinKinou(srGetTokutejitenTmttknInfoBeanMae.getKousinKinou());
                        khSisuurendoTmttknMae.setVersion(srGetTokutejitenTmttknInfoBeanMae.getVersion());
                        khSisuurendoTmttknMae.setItenmaeteiritutmttkngk(srGetTokutejitenTmttknInfoBeanMae
                            .getItenmaeteiritutmttkngk());
                        khSisuurendoTmttknMae.setItenmaesisuurendoutmttkngk(srGetTokutejitenTmttknInfoBeanMae
                            .getItenmaesisuurendoutmttkngk());

                        khSisuurendoTmttknBean.setKhSisuurendoTmttknMae(khSisuurendoTmttknMae);

                        SrGetTokutejitenTmttknInfoBean srGetTokutejitenTmttknInfoBeanAto = getTaiouRecord(
                            pSrGetTokutejitenTmttknInfoBeanList, i);

                        IT_KhSisuurendoTmttkn khSisuurendoTmttknAto = new IT_KhSisuurendoTmttkn();

                        khSisuurendoTmttknAto.setKbnkey(srGetTokutejitenTmttknInfoBeanAto.getKbnkey());
                        khSisuurendoTmttknAto.setSyono(srGetTokutejitenTmttknInfoBeanAto.getSyono());
                        khSisuurendoTmttknAto.setTmttkntaisyouym(srGetTokutejitenTmttknInfoBeanAto.getTmttkntaisyouym());
                        khSisuurendoTmttknAto.setRenno(srGetTokutejitenTmttknInfoBeanAto.getRenno());
                        khSisuurendoTmttknAto.setTmttknkouryokukaisiymd(srGetTokutejitenTmttknInfoBeanAto
                            .getTmttknkouryokukaisiymd());
                        khSisuurendoTmttknAto.setTeiritutmttkngk(srGetTokutejitenTmttknInfoBeanAto.getTeiritutmttkngk());
                        khSisuurendoTmttknAto.setSisuurendoutmttkngk(srGetTokutejitenTmttknInfoBeanAto
                            .getSisuurendoutmttkngk());
                        khSisuurendoTmttknAto.setSisuuupritu(srGetTokutejitenTmttknInfoBeanAto.getSisuuupritu());
                        khSisuurendoTmttknAto.setTmttknzoukaritu(srGetTokutejitenTmttknInfoBeanAto.getTmttknzoukaritu());
                        khSisuurendoTmttknAto.setTmttknhaneitmmshanteiymd(srGetTokutejitenTmttknInfoBeanAto
                            .getTmttknhaneitmmshanteiymd());
                        khSisuurendoTmttknAto.setTmttknhaneisisuu(srGetTokutejitenTmttknInfoBeanAto.getTmttknhaneisisuu());
                        khSisuurendoTmttknAto.setGyoumuKousinKinou(srGetTokutejitenTmttknInfoBeanAto.getGyoumuKousinKinou());
                        khSisuurendoTmttknAto.setGyoumuKousinsyaId(srGetTokutejitenTmttknInfoBeanAto.getGyoumuKousinsyaId());
                        khSisuurendoTmttknAto.setGyoumuKousinTime(srGetTokutejitenTmttknInfoBeanAto.getGyoumuKousinTime());
                        khSisuurendoTmttknAto.setKousinsyaId(srGetTokutejitenTmttknInfoBeanAto.getKousinsyaId());
                        khSisuurendoTmttknAto.setKousinTime(srGetTokutejitenTmttknInfoBeanAto.getKousinTime());
                        khSisuurendoTmttknAto.setKousinKinou(srGetTokutejitenTmttknInfoBeanAto.getKousinKinou());
                        khSisuurendoTmttknAto.setVersion(srGetTokutejitenTmttknInfoBeanAto.getVersion());
                        khSisuurendoTmttknAto.setItenmaeteiritutmttkngk(srGetTokutejitenTmttknInfoBeanAto
                            .getItenmaeteiritutmttkngk());
                        khSisuurendoTmttknAto.setItenmaesisuurendoutmttkngk(srGetTokutejitenTmttknInfoBeanAto
                            .getItenmaesisuurendoutmttkngk());

                        khSisuurendoTmttknBean.setKhSisuurendoTmttknAto(khSisuurendoTmttknAto);

                        break;

                    }

                    else if (IKhozenCommonConstants.KINOUID_GENGAKU.equals(srGetTokutejitenTmttknInfoBean.getGyoumuKousinKinou())) {

                        IT_KhSisuurendoTmttkn khSisuurendoTmttknAto = new IT_KhSisuurendoTmttkn();

                        khSisuurendoTmttknAto.setKbnkey(srGetTokutejitenTmttknInfoBean.getKbnkey());
                        khSisuurendoTmttknAto.setSyono(srGetTokutejitenTmttknInfoBean.getSyono());
                        khSisuurendoTmttknAto.setTmttkntaisyouym(srGetTokutejitenTmttknInfoBean.getTmttkntaisyouym());
                        khSisuurendoTmttknAto.setRenno(srGetTokutejitenTmttknInfoBean.getRenno());
                        khSisuurendoTmttknAto.setTmttknkouryokukaisiymd(srGetTokutejitenTmttknInfoBean
                            .getTmttknkouryokukaisiymd());
                        khSisuurendoTmttknAto.setTeiritutmttkngk(srGetTokutejitenTmttknInfoBean.getTeiritutmttkngk());
                        khSisuurendoTmttknAto.setSisuurendoutmttkngk(srGetTokutejitenTmttknInfoBean.getSisuurendoutmttkngk());
                        khSisuurendoTmttknAto.setSisuuupritu(srGetTokutejitenTmttknInfoBean.getSisuuupritu());
                        khSisuurendoTmttknAto.setTmttknzoukaritu(srGetTokutejitenTmttknInfoBean.getTmttknzoukaritu());
                        khSisuurendoTmttknAto.setTmttknhaneitmmshanteiymd(srGetTokutejitenTmttknInfoBean
                            .getTmttknhaneitmmshanteiymd());
                        khSisuurendoTmttknAto.setTmttknhaneisisuu(srGetTokutejitenTmttknInfoBean.getTmttknhaneisisuu());
                        khSisuurendoTmttknAto.setGyoumuKousinKinou(srGetTokutejitenTmttknInfoBean.getGyoumuKousinKinou());
                        khSisuurendoTmttknAto.setGyoumuKousinsyaId(srGetTokutejitenTmttknInfoBean.getGyoumuKousinsyaId());
                        khSisuurendoTmttknAto.setGyoumuKousinTime(srGetTokutejitenTmttknInfoBean.getGyoumuKousinTime());
                        khSisuurendoTmttknAto.setKousinsyaId(srGetTokutejitenTmttknInfoBean.getKousinsyaId());
                        khSisuurendoTmttknAto.setKousinTime(srGetTokutejitenTmttknInfoBean.getKousinTime());
                        khSisuurendoTmttknAto.setKousinKinou(srGetTokutejitenTmttknInfoBean.getKousinKinou());
                        khSisuurendoTmttknAto.setVersion(srGetTokutejitenTmttknInfoBean.getVersion());
                        khSisuurendoTmttknAto.setItenmaeteiritutmttkngk(srGetTokutejitenTmttknInfoBean
                            .getItenmaeteiritutmttkngk());
                        khSisuurendoTmttknAto.setItenmaesisuurendoutmttkngk(srGetTokutejitenTmttknInfoBean
                            .getItenmaesisuurendoutmttkngk());

                        khSisuurendoTmttknBean.setKhSisuurendoTmttknAto(khSisuurendoTmttknAto);

                        SrGetTokutejitenTmttknInfoBean srGetTokutejitenTmttknInfoBeanMae = getTaiouRecord(
                            pSrGetTokutejitenTmttknInfoBeanList, i);

                        IT_KhSisuurendoTmttkn khSisuurendoTmttknMae = new IT_KhSisuurendoTmttkn();

                        khSisuurendoTmttknMae.setKbnkey(srGetTokutejitenTmttknInfoBeanMae.getKbnkey());
                        khSisuurendoTmttknMae.setSyono(srGetTokutejitenTmttknInfoBeanMae.getSyono());
                        khSisuurendoTmttknMae.setTmttkntaisyouym(srGetTokutejitenTmttknInfoBeanMae.getTmttkntaisyouym());
                        khSisuurendoTmttknMae.setRenno(srGetTokutejitenTmttknInfoBeanMae.getRenno());
                        khSisuurendoTmttknMae.setTmttknkouryokukaisiymd(srGetTokutejitenTmttknInfoBeanMae
                            .getTmttknkouryokukaisiymd());
                        khSisuurendoTmttknMae.setTeiritutmttkngk(srGetTokutejitenTmttknInfoBeanMae.getTeiritutmttkngk());
                        khSisuurendoTmttknMae.setSisuurendoutmttkngk(srGetTokutejitenTmttknInfoBeanMae
                            .getSisuurendoutmttkngk());
                        khSisuurendoTmttknMae.setSisuuupritu(srGetTokutejitenTmttknInfoBeanMae.getSisuuupritu());
                        khSisuurendoTmttknMae.setTmttknzoukaritu(srGetTokutejitenTmttknInfoBeanMae.getTmttknzoukaritu());
                        khSisuurendoTmttknMae.setTmttknhaneitmmshanteiymd(srGetTokutejitenTmttknInfoBeanMae
                            .getTmttknhaneitmmshanteiymd());
                        khSisuurendoTmttknMae.setTmttknhaneisisuu(srGetTokutejitenTmttknInfoBeanMae.getTmttknhaneisisuu());
                        khSisuurendoTmttknMae.setGyoumuKousinKinou(srGetTokutejitenTmttknInfoBeanMae.getGyoumuKousinKinou());
                        khSisuurendoTmttknMae.setGyoumuKousinsyaId(srGetTokutejitenTmttknInfoBeanMae.getGyoumuKousinsyaId());
                        khSisuurendoTmttknMae.setGyoumuKousinTime(srGetTokutejitenTmttknInfoBeanMae.getGyoumuKousinTime());
                        khSisuurendoTmttknMae.setKousinsyaId(srGetTokutejitenTmttknInfoBeanMae.getKousinsyaId());
                        khSisuurendoTmttknMae.setKousinTime(srGetTokutejitenTmttknInfoBeanMae.getKousinTime());
                        khSisuurendoTmttknMae.setKousinKinou(srGetTokutejitenTmttknInfoBeanMae.getKousinKinou());
                        khSisuurendoTmttknMae.setVersion(srGetTokutejitenTmttknInfoBeanMae.getVersion());
                        khSisuurendoTmttknMae.setItenmaeteiritutmttkngk(srGetTokutejitenTmttknInfoBeanMae
                            .getItenmaeteiritutmttkngk());
                        khSisuurendoTmttknMae.setItenmaesisuurendoutmttkngk(srGetTokutejitenTmttknInfoBeanMae
                            .getItenmaesisuurendoutmttkngk());

                        khSisuurendoTmttknBean.setKhSisuurendoTmttknMae(khSisuurendoTmttknMae);

                        break;
                    }
                }
            }
        }

        else {

            for (SrGetTokutejitenTmttknInfoBean srGetTokutejitenTmttknInfoBean : pSrGetTokutejitenTmttknInfoBeanList) {

                if (srGetTokutejitenTmttknInfoBean.getTmttknkouryokukaisiymd() == null) {

                    continue;
                }

                if (BizDateUtil.compareYmd(srGetTokutejitenTmttknInfoBean.getTmttknkouryokukaisiymd(), pKijyunYmd) == BizDateUtil.COMPARE_LESSER
                    || BizDateUtil.compareYmd(srGetTokutejitenTmttknInfoBean.getTmttknkouryokukaisiymd(), pKijyunYmd) == BizDateUtil.COMPARE_EQUAL) {

                    IT_KhSisuurendoTmttkn khSisuurendoTmttknAto = new IT_KhSisuurendoTmttkn();

                    khSisuurendoTmttknAto.setKbnkey(srGetTokutejitenTmttknInfoBean.getKbnkey());
                    khSisuurendoTmttknAto.setSyono(srGetTokutejitenTmttknInfoBean.getSyono());
                    khSisuurendoTmttknAto.setTmttkntaisyouym(srGetTokutejitenTmttknInfoBean.getTmttkntaisyouym());
                    khSisuurendoTmttknAto.setRenno(srGetTokutejitenTmttknInfoBean.getRenno());
                    khSisuurendoTmttknAto.setTmttknkouryokukaisiymd(srGetTokutejitenTmttknInfoBean
                        .getTmttknkouryokukaisiymd());
                    khSisuurendoTmttknAto.setTeiritutmttkngk(srGetTokutejitenTmttknInfoBean.getTeiritutmttkngk());
                    khSisuurendoTmttknAto.setSisuurendoutmttkngk(srGetTokutejitenTmttknInfoBean.getSisuurendoutmttkngk());
                    khSisuurendoTmttknAto.setSisuuupritu(srGetTokutejitenTmttknInfoBean.getSisuuupritu());
                    khSisuurendoTmttknAto.setTmttknzoukaritu(srGetTokutejitenTmttknInfoBean.getTmttknzoukaritu());
                    khSisuurendoTmttknAto.setTmttknhaneitmmshanteiymd(srGetTokutejitenTmttknInfoBean
                        .getTmttknhaneitmmshanteiymd());
                    khSisuurendoTmttknAto.setTmttknhaneisisuu(srGetTokutejitenTmttknInfoBean.getTmttknhaneisisuu());
                    khSisuurendoTmttknAto.setGyoumuKousinKinou(srGetTokutejitenTmttknInfoBean.getGyoumuKousinKinou());
                    khSisuurendoTmttknAto.setGyoumuKousinsyaId(srGetTokutejitenTmttknInfoBean.getGyoumuKousinsyaId());
                    khSisuurendoTmttknAto.setGyoumuKousinTime(srGetTokutejitenTmttknInfoBean.getGyoumuKousinTime());
                    khSisuurendoTmttknAto.setKousinsyaId(srGetTokutejitenTmttknInfoBean.getKousinsyaId());
                    khSisuurendoTmttknAto.setKousinTime(srGetTokutejitenTmttknInfoBean.getKousinTime());
                    khSisuurendoTmttknAto.setKousinKinou(srGetTokutejitenTmttknInfoBean.getKousinKinou());
                    khSisuurendoTmttknAto.setVersion(srGetTokutejitenTmttknInfoBean.getVersion());
                    khSisuurendoTmttknAto.setItenmaeteiritutmttkngk(srGetTokutejitenTmttknInfoBean
                        .getItenmaeteiritutmttkngk());
                    khSisuurendoTmttknAto.setItenmaesisuurendoutmttkngk(srGetTokutejitenTmttknInfoBean
                        .getItenmaesisuurendoutmttkngk());

                    khSisuurendoTmttknBean.setKhSisuurendoTmttknAto(khSisuurendoTmttknAto);

                    break;

                }

            }
        }

        logger.debug("△ 検索処理 終了");

        return khSisuurendoTmttknBean;
    }

    private List<IT_KhSisuurendoTmttkn> createTmpList(List<IT_KhSisuurendoTmttkn> pKhSisuurendoTmttknList) {

        IT_KhSisuurendoTmttkn khSisuurendoTmttkn = null;

        List<IT_KhSisuurendoTmttkn> khSisuurendoTmttknItijiList = new ArrayList<IT_KhSisuurendoTmttkn>();

        for (IT_KhSisuurendoTmttkn khSisuurendoTmttkn1 : pKhSisuurendoTmttknList) {

            khSisuurendoTmttkn = new IT_KhSisuurendoTmttkn();
            khSisuurendoTmttkn = khSisuurendoTmttkn1;

            khSisuurendoTmttknItijiList.add(khSisuurendoTmttkn);
        }

        return khSisuurendoTmttknItijiList;

    }

    private IT_KhSisuurendoTmttkn getTmttknEntity(List<IT_KhSisuurendoTmttkn> pKhSisuurendoTmttknList,
        String pGyoumuKousinKinou, int pIndex) {

        int count = 0;

        IT_KhSisuurendoTmttkn khSisuurendoTmttkn = null;

        String gyoumuKousinKinou = "";

        for (IT_KhSisuurendoTmttkn khSisuurendoTmttkn1 : pKhSisuurendoTmttknList) {

            if (IKhozenCommonConstants.KINOUID_GENGAKU.equals(khSisuurendoTmttkn1.getGyoumuKousinKinou()) && 
                khSisuurendoTmttkn1.getRenno() == SrCommonConstants.RENBAN_1) {
                
                gyoumuKousinKinou = IKhozenCommonConstants.KINOUID_KHSISUURENDOTMTTKNHANEI;

            } else {

                gyoumuKousinKinou = khSisuurendoTmttkn1.getGyoumuKousinKinou();

            }

            if (pGyoumuKousinKinou.equals(gyoumuKousinKinou)) {
                count = count + 1;
            }

            if (count == pIndex) {

                khSisuurendoTmttkn = khSisuurendoTmttkn1;

                break;
            }
        }

        return khSisuurendoTmttkn;
    }

    private SrGetTokutejitenTmttknInfoBean getTaiouRecord(
        List<SrGetTokutejitenTmttknInfoBean> pSrGetTokutejitenTmttknInfoBeanList, int pIndex) {

        SrGetTokutejitenTmttknInfoBean srGetTokutejitenTmttknInfoBean = null;

        for (int i = pIndex + 1 ; i < pSrGetTokutejitenTmttknInfoBeanList.size(); i++) {

            SrGetTokutejitenTmttknInfoBean srGetTokutejitenTmttknInfoBean1 = pSrGetTokutejitenTmttknInfoBeanList.get(i);

            if (!KINOUID_TMTTKNINFOHANEI.equals(srGetTokutejitenTmttknInfoBean1.getGyoumuKousinKinou()) &&
                !KINOUID_TMTTKNINFOHANEITRKS.equals(srGetTokutejitenTmttknInfoBean1.getGyoumuKousinKinou())) {

                srGetTokutejitenTmttknInfoBean = srGetTokutejitenTmttknInfoBean1;

                break;
            }
        }

        return srGetTokutejitenTmttknInfoBean;

    }

    private void setTmttknkouryokukaisiymdForComp(List<SrGetTokutejitenTmttknInfoBean> pSrGetTokutejitenTmttknInfoBeanList) {
        
        BizDate tmttknkouryokukaisiymd = null;

        for (int i = 0; i < pSrGetTokutejitenTmttknInfoBeanList.size(); i++) {

            SrGetTokutejitenTmttknInfoBean srGetTokutejitenTmttknInfoBean = pSrGetTokutejitenTmttknInfoBeanList.get(i);

            if (IKhozenCommonConstants.KINOUID_GENGAKU.equals(srGetTokutejitenTmttknInfoBean.getGyoumuKousinKinou())) {

                tmttknkouryokukaisiymd = srGetTokutejitenTmttknInfoBean.getTmttknkouryokukaisiymd();

                srGetTokutejitenTmttknInfoBean.setTmttknkouryokukaisiymdForComp(srGetTokutejitenTmttknInfoBean.getTmttknkouryokukaisiymd());

            }
            else if (IKhozenCommonConstants.KINOUID_KHSISUURENDOTMTTKNHANEI.equals(srGetTokutejitenTmttknInfoBean.getGyoumuKousinKinou())) {

                srGetTokutejitenTmttknInfoBean.setTmttknkouryokukaisiymdForComp(srGetTokutejitenTmttknInfoBean.getTmttknkouryokukaisiymd());

            }
            else if (KINOUID_TMTTKNINFOHANEITRKS.equals(srGetTokutejitenTmttknInfoBean.getGyoumuKousinKinou())) {

                srGetTokutejitenTmttknInfoBean.setTmttknkouryokukaisiymdForComp(srGetTokutejitenTmttknInfoBean.getTmttknkouryokukaisiymd());

            }
            else if (KINOUID_TMTTKNINFOHANEI.equals(srGetTokutejitenTmttknInfoBean.getGyoumuKousinKinou())) {

                if (tmttknkouryokukaisiymd != null) {

                    if (BizDateUtil.compareYmd(tmttknkouryokukaisiymd, srGetTokutejitenTmttknInfoBean.getTmttknkouryokukaisiymd()) == BizDateUtil.COMPARE_LESSER) {

                        srGetTokutejitenTmttknInfoBean.setTmttknkouryokukaisiymdForComp(tmttknkouryokukaisiymd);

                        pSrGetTokutejitenTmttknInfoBeanList.get(i - 1).setTmttknkouryokukaisiymdForComp(tmttknkouryokukaisiymd);

                    } else {

                        srGetTokutejitenTmttknInfoBean.setTmttknkouryokukaisiymdForComp(srGetTokutejitenTmttknInfoBean.getTmttknkouryokukaisiymd());

                        pSrGetTokutejitenTmttknInfoBeanList.get(i - 1).setTmttknkouryokukaisiymdForComp(srGetTokutejitenTmttknInfoBean.getTmttknkouryokukaisiymd());

                    }

                } else {
                    srGetTokutejitenTmttknInfoBean.setTmttknkouryokukaisiymdForComp(srGetTokutejitenTmttknInfoBean.getTmttknkouryokukaisiymd());

                    pSrGetTokutejitenTmttknInfoBeanList.get(i - 1).setTmttknkouryokukaisiymdForComp(srGetTokutejitenTmttknInfoBean.getTmttknkouryokukaisiymd());
                }

            } else {
                srGetTokutejitenTmttknInfoBean.setTmttknkouryokukaisiymdForComp(srGetTokutejitenTmttknInfoBean.getTmttknkouryokukaisiymd());

            }

        }

    }

    private KhSisuurendoTmttknBean getSisuurendoTmttknInfo2(BizDate pKijyunYmd, String pHenkouSikibetuKey,
        List<SrGetTokutejitenTmttknInfoBean> pSrGetTokutejitenTmttknInfoBeanList) {

        List<SrGetTokutejitenTmttknInfoBean> sameDayLst = new ArrayList<SrGetTokutejitenTmttknInfoBean>();

        SrGetTokutejitenTmttknInfoBean srGetTokutejitenTmttknInfoBean = null;

        IT_KhSisuurendoTmttkn khSisuurendoTmttknAto = null;

        KhSisuurendoTmttknBean khSisuurendoTmttknBean = new KhSisuurendoTmttknBean();

        for (int i = 0; i < pSrGetTokutejitenTmttknInfoBeanList.size(); i++) {

            srGetTokutejitenTmttknInfoBean = pSrGetTokutejitenTmttknInfoBeanList.get(i);

            if (srGetTokutejitenTmttknInfoBean.getTmttknkouryokukaisiymd() != null && 
                BizDateUtil.compareYmd(srGetTokutejitenTmttknInfoBean.getTmttknkouryokukaisiymd(), pKijyunYmd) == BizDateUtil.COMPARE_EQUAL) {

                sameDayLst.add(srGetTokutejitenTmttknInfoBean);
            }

        }

        for (int i = 0; i < sameDayLst.size(); i++) {

            if (BizUtil.isBlank(sameDayLst.get(i).getHenkousikibetukey()) || 
                pHenkouSikibetuKey.compareTo(sameDayLst.get(i).getHenkousikibetukey()) > 0) {

                khSisuurendoTmttknAto = new IT_KhSisuurendoTmttkn();
                
                BeanUtil.copyProperties(khSisuurendoTmttknAto, sameDayLst.get(i));
                
                khSisuurendoTmttknBean.setKhSisuurendoTmttknAto(khSisuurendoTmttknAto);

                return khSisuurendoTmttknBean;

            }

        }

        for (int i = 0; i < pSrGetTokutejitenTmttknInfoBeanList.size(); i++) {

            srGetTokutejitenTmttknInfoBean = pSrGetTokutejitenTmttknInfoBeanList.get(i);

            if (srGetTokutejitenTmttknInfoBean.getTmttknkouryokukaisiymd() == null) {
                
                continue;

            }

            if (BizDateUtil.compareYmd(srGetTokutejitenTmttknInfoBean.getTmttknkouryokukaisiymd(), pKijyunYmd) == BizDateUtil.COMPARE_LESSER) {

                khSisuurendoTmttknAto = new IT_KhSisuurendoTmttkn();

                BeanUtil.copyProperties(khSisuurendoTmttknAto, srGetTokutejitenTmttknInfoBean);

                khSisuurendoTmttknBean.setKhSisuurendoTmttknAto(khSisuurendoTmttknAto);
            
                break;

            }

        }

        return khSisuurendoTmttknBean;
    }

    private String getNextHenkousikibetukey(List<IT_KhTtdkRireki> pKhTtdkRirekiList, int pIdx) {

        String henkousikibetukey = "";

        for (int i = pIdx; i < pKhTtdkRirekiList.size(); i++) {

            if ((IKhozenCommonConstants.KINOUID_KHSISUURENDOTMTTKNHANEI.equals(pKhTtdkRirekiList.get(i).getGyoumuKousinKinou()) &&
                C_SyoriKbn.TMTTKNHANEI.eq(pKhTtdkRirekiList.get(i).getSyorikbn()))
                || (IKhozenCommonConstants.KINOUID_KHSISUURENDOTMTTKNHANEI.equals(pKhTtdkRirekiList.get(i).getGyoumuKousinKinou()) &&
                    C_SyoriKbn.TMTTKNHANEI_ITEN.eq(pKhTtdkRirekiList.get(i).getSyorikbn()))) {

                henkousikibetukey = pKhTtdkRirekiList.get(i).getHenkousikibetukey();

                break;
           }

        }

        return henkousikibetukey;

    }

}
