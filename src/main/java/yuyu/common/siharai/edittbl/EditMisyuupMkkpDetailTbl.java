package yuyu.common.siharai.edittbl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.date.BizDate;

import org.slf4j.Logger;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.siharai.sicommon.SiDetailMikeikapBean;
import yuyu.common.siharai.sicommon.SiDetailMisyuupBean;
import yuyu.def.MessageId;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.JT_MisyuupMkkpDetail;
import yuyu.infr.kinoumode.KinouMode;

/**
 * 保険金給付金支払 保険金給付金支払共通 未収Ｐ未経過Ｐ明細TBL編集
 */
public class EditMisyuupMkkpDetailTbl {

    @Inject
    private static Logger logger;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private KinouMode kinouMode;

    public EditMisyuupMkkpDetailTbl() {
        super();
    }

    public List<JT_MisyuupMkkpDetail> exec(String pSkno, String pSyono, Integer pSeikyuurirekino,
        List<SiDetailMisyuupBean> pSiDetailMisyuupBeanList, List<SiDetailMikeikapBean> pSiDetailMikeikapBeanList) {

        logger.debug("▽ 未収Ｐ未経過Ｐ明細TBL編集 開始");

        if (BizUtil.isBlank(pSkno)) {
            throw new BizAppException(MessageId.EJS1005, "skno");
        }
        if (BizUtil.isBlank(pSyono)) {
            throw new BizAppException(MessageId.EJS1005, "syono");
        }
        if (pSeikyuurirekino == null) {
            throw new BizAppException(MessageId.EJS1005, "seikyuurirekino");
        }

        Integer datarenno = 1;
        String functionId = kinou.getKinouId();
        String kinouModeId = kinouMode.getKinouMode();
        String userId = baseUserInfo.getUserId();
        String sysTime = BizDate.getSysDateTimeMilli();

        List<JT_MisyuupMkkpDetail> misyuupMkkpDetailList = new ArrayList<>();

        if (pSiDetailMisyuupBeanList.size() != 0) {
            for (SiDetailMisyuupBean siDetailMisyuupBean : pSiDetailMisyuupBeanList) {

                JT_MisyuupMkkpDetail misyuupMkkpDetail = new JT_MisyuupMkkpDetail();

                misyuupMkkpDetail.setSkno(pSkno);
                misyuupMkkpDetail.setSyono(pSyono);
                misyuupMkkpDetail.setSeikyuurirekino(pSeikyuurirekino);
                misyuupMkkpDetail.setDatarenno(datarenno);
                misyuupMkkpDetail.setDtlmisyuup(siDetailMisyuupBean.getDtlmisyuup());
                misyuupMkkpDetail.setDtlmisyuupgaika(siDetailMisyuupBean.getDtlmisyuupgaika());
                misyuupMkkpDetail.setDtlmisyuupgaikayenknsnkngk(siDetailMisyuupBean.getDtlmisyuupgaikayenkingk());
                misyuupMkkpDetail.setDtlmisyuupiktnkumu(siDetailMisyuupBean.getDtlmisyuupiktnyuukinnumu());
                misyuupMkkpDetail.setDtlmisyuuphrkkaisuu(siDetailMisyuupBean.getDtlmisyuuphrkkaisuu());
                misyuupMkkpDetail.setDtlmisyuupjtkaisuuy(siDetailMisyuupBean.getDtlmisyuupjyutoukaisuuy());
                misyuupMkkpDetail.setDtlmisyuupjtkaisuum(siDetailMisyuupBean.getDtlmisyuupjyutoukaisuum());
                misyuupMkkpDetail.setDtlmisyuupjytym(siDetailMisyuupBean.getDtlmisyuupjyuutouym());
                misyuupMkkpDetail.setKossyoricd(functionId);
                misyuupMkkpDetail.setKossyorisscd(kinouModeId);
                misyuupMkkpDetail.setGyoumuKousinsyaId(userId);
                misyuupMkkpDetail.setGyoumuKousinTime(sysTime);

                BizPropertyInitializer.initialize(misyuupMkkpDetail);

                misyuupMkkpDetailList.add(misyuupMkkpDetail);

                datarenno = datarenno + 1;
            }
        }

        if (pSiDetailMikeikapBeanList.size() != 0) {
            for (SiDetailMikeikapBean siDetailMikeikapBean : pSiDetailMikeikapBeanList) {

                JT_MisyuupMkkpDetail misyuupMkkpDetail = new JT_MisyuupMkkpDetail();

                misyuupMkkpDetail.setSkno(pSkno);
                misyuupMkkpDetail.setSyono(pSyono);
                misyuupMkkpDetail.setSeikyuurirekino(Integer.valueOf(pSeikyuurirekino));
                misyuupMkkpDetail.setDatarenno(datarenno);
                misyuupMkkpDetail.setDtlmikeikap(siDetailMikeikapBean.getDtlmikeikap());
                misyuupMkkpDetail.setDtlmikeikapgaika(siDetailMikeikapBean.getDtlmikeikapgaika());
                misyuupMkkpDetail.setDtlmikeikapnykdenymd(siDetailMikeikapBean.getDtlmikeikapnykdenymd());
                misyuupMkkpDetail.setDtlmikeikaphrkkaisuu(siDetailMikeikapBean.getDtlmikeikaphrkkaisuu());
                misyuupMkkpDetail.setDtlmikeikapjtkaisuuy(siDetailMikeikapBean.getDtlmikeikapjyutoukaisuuy());
                misyuupMkkpDetail.setDtlmikeikapjtkaisuum(siDetailMikeikapBean.getDtlmikeikapjyutoukaisuum());
                misyuupMkkpDetail.setDtlmikeikapjytym(siDetailMikeikapBean.getDtlmikeikapjyuutouym());
                misyuupMkkpDetail.setKossyoricd(functionId);
                misyuupMkkpDetail.setKossyorisscd(kinouModeId);
                misyuupMkkpDetail.setGyoumuKousinsyaId(userId);
                misyuupMkkpDetail.setGyoumuKousinTime(sysTime);

                BizPropertyInitializer.initialize(misyuupMkkpDetail);

                misyuupMkkpDetailList.add(misyuupMkkpDetail);

                datarenno = datarenno + 1;
            }
        }
        logger.debug("△ 未収Ｐ未経過Ｐ明細TBL編集 終了");

        return misyuupMkkpDetailList;
    }
}
