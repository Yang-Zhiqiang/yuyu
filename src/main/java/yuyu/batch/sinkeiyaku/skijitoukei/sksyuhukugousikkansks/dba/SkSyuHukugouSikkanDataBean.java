package yuyu.batch.sinkeiyaku.skijitoukei.sksyuhukugousikkansks.dba;

import java.io.Serializable;

import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_BosyuuDairitenAtkiKeitaiKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_IjitoukeiHokensyuruiKbn;
import yuyu.def.classification.C_IjitoukeiTikShrTkykKbn;
import yuyu.def.classification.C_IjitoukeiZennouKbn;
import yuyu.def.classification.C_NensyuuKbn;
import yuyu.def.classification.C_SirajiKykKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;

/**
 * 新契約 主契約複合疾患データBeanクラスです。
 */
public class SkSyuHukugouSikkanDataBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private int hknnendo;

    @Getter
    @Setter
    private String ijitoukeidaihyousyurui;

    @Getter
    @Setter
    private String kyknendo;

    @Getter
    @Setter
    private C_Hhknsei hhknsei;

    @Getter
    @Setter
    private int kykage;

    @Getter
    @Setter
    private int toutatunenrei;

    @Getter
    @Setter
    private String atukaibetu;

    @Getter
    @Setter
    private String ijitoukeisinsahouhou;

    @Getter
    @Setter
    private String ketteikekkaa;

    @Getter
    @Setter
    private String sibousrank;

    @Getter
    @Setter
    private String jissituhosyousrank;

    @Getter
    @Setter
    private C_SirajiKykKbn sirajikykkbn;

    @Getter
    @Setter
    private String hrkhouhoukbn;

    @Getter
    @Setter
    private C_IjitoukeiHokensyuruiKbn ijitoukeihokensyuruikbn;

    @Getter
    @Setter
    private String daisiincd;

    @Getter
    @Setter
    private String tyuusiincd;

    @Getter
    @Setter
    private String siincd;

    @Getter
    @Setter
    private String nenreihousikikbn;

    @Getter
    @Setter
    private String hhknsykgycd;

    @Getter
    @Setter
    private String hhkntodouhukencd;

    @Getter
    @Setter
    private String botaisisyaeigyouhonbu;

    @Getter
    @Setter
    private String sisyaeigyoubu;

    @Getter
    @Setter
    private String aatsukaishasoshikicd;

    @Getter
    @Setter
    private C_NensyuuKbn hhknnensyuukbn;

    @Getter
    @Setter
    private String hanbaikeirokbn;

    @Getter
    @Setter
    private String oyadrtencd;

    @Getter
    @Setter
    private String tratkiagcd;

    @Getter
    @Setter
    private C_BosyuuDairitenAtkiKeitaiKbn bosyuudairitenatkikeitaikbn;

    @Getter
    @Setter
    private C_Tuukasyu kyktuukasyu;

    @Getter
    @Setter
    private C_Tuukasyu hrktuukasyu;

    @Getter
    @Setter
    private String syouhncd;

    @Getter
    @Setter
    private C_UmuKbn initsbjiyensitihsytkhukaumu;

    @Getter
    @Setter
    private C_UmuKbn jyudkaigomeharaitkhukaumu;

    @Getter
    @Setter
    private C_IjitoukeiZennouKbn ijitoukeizennoukbn;

    @Getter
    @Setter
    private int dai1hknkkn;

    @Getter
    @Setter
    private C_IjitoukeiTikShrTkykKbn ijitoukeitikshrtkykkbn;

    @Getter
    @Setter
    private BizNumber ijitoukeikeikan;

    @Getter
    @Setter
    private Long ijitoukeisiboun;

    @Getter
    @Setter
    private BizNumber ijitoukeikeikas;

    @Getter
    @Setter
    private Long ijitoukeisibous;


    public SkSyuHukugouSikkanDataBean(
        Integer pHknnendo,
        String pIjitoukeidaihyousyurui,
        String pKyknendo,
        C_Hhknsei pHhknsei,
        Integer pKykage,
        Integer pToutatunenrei,
        String pAtukaibetu,
        String pIjitoukeisinsahouhou,
        String pKetteikekkaa,
        String pSibousrank,
        String pJissituhosyousrank,
        C_SirajiKykKbn pSirajikykkbn,
        String pHrkhouhoukbn,
        C_IjitoukeiHokensyuruiKbn pIjitoukeihokensyuruikbn,
        String pDaisiincd,
        String pTyuusiincd,
        String pSiincd,
        String pNenreihousikikbn,
        String pHhknsykgycd,
        String pHhkntodouhukencd,
        String pBotaisisyaeigyouhonbu,
        String pSisyaeigyoubu,
        String pAatsukaishasoshikicd,
        C_NensyuuKbn pHhknnensyuukbn,
        String pHanbaikeirokbn,
        String pOyadrtencd,
        String pTratkiagcd,
        C_BosyuuDairitenAtkiKeitaiKbn pBosyuudairitenatkikeitaikbn,
        C_Tuukasyu pKyktuukasyu,
        C_Tuukasyu pHrktuukasyu,
        String pSyouhncd,
        C_UmuKbn pInitsbjiyensitihsytkhukaumu,
        C_UmuKbn pJyudkaigomeharaitkhukaumu,
        C_IjitoukeiZennouKbn pIjitoukeizennoukbn,
        Integer pDai1hknkkn,
        C_IjitoukeiTikShrTkykKbn pIjitoukeitikshrtkykkbn,
        BizNumber pIjitoukeikeikan,
        Long pIjitoukeisiboun,
        BizNumber pIjitoukeikeikas,
        Long pIjitoukeisibous
        ) {

        hknnendo = pHknnendo;
        ijitoukeidaihyousyurui = pIjitoukeidaihyousyurui;
        kyknendo = pKyknendo;
        hhknsei = pHhknsei;
        kykage = pKykage;
        toutatunenrei = pToutatunenrei;
        atukaibetu = pAtukaibetu;
        ijitoukeisinsahouhou = pIjitoukeisinsahouhou;
        ketteikekkaa = pKetteikekkaa;
        sibousrank = pSibousrank;
        jissituhosyousrank = pJissituhosyousrank;
        sirajikykkbn = pSirajikykkbn;
        hrkhouhoukbn = pHrkhouhoukbn;
        ijitoukeihokensyuruikbn = pIjitoukeihokensyuruikbn;
        daisiincd = pDaisiincd;
        tyuusiincd = pTyuusiincd;
        siincd = pSiincd;
        nenreihousikikbn = pNenreihousikikbn;
        hhknsykgycd = pHhknsykgycd;
        hhkntodouhukencd = pHhkntodouhukencd;
        botaisisyaeigyouhonbu = pBotaisisyaeigyouhonbu;
        sisyaeigyoubu = pSisyaeigyoubu;
        aatsukaishasoshikicd = pAatsukaishasoshikicd;
        hhknnensyuukbn = pHhknnensyuukbn;
        hanbaikeirokbn = pHanbaikeirokbn;
        oyadrtencd = pOyadrtencd;
        tratkiagcd = pTratkiagcd;
        bosyuudairitenatkikeitaikbn = pBosyuudairitenatkikeitaikbn;
        kyktuukasyu = pKyktuukasyu;
        hrktuukasyu = pHrktuukasyu;
        syouhncd = pSyouhncd;
        initsbjiyensitihsytkhukaumu = pInitsbjiyensitihsytkhukaumu;
        jyudkaigomeharaitkhukaumu = pJyudkaigomeharaitkhukaumu;
        ijitoukeizennoukbn = pIjitoukeizennoukbn;
        dai1hknkkn = pDai1hknkkn;
        ijitoukeitikshrtkykkbn = pIjitoukeitikshrtkykkbn;
        ijitoukeikeikan = pIjitoukeikeikan;
        ijitoukeisiboun = pIjitoukeisiboun;
        ijitoukeikeikas = pIjitoukeikeikas;
        ijitoukeisibous = pIjitoukeisibous;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
