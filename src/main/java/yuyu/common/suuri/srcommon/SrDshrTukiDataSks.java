package yuyu.common.suuri.srcommon;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.uniquekey.UniqueKeyGenerator;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.def.db.entity.IT_KhDshrTuki;
import yuyu.def.db.entity.IT_KhHaitouKanri;
import yuyu.def.db.entity.IT_KhTumitateDKanri;
import yuyu.def.db.entity.JT_SiDshrTuki;

/**
 *  数理 数理共通 Ｄ支払統計データ作成
 */
public class SrDshrTukiDataSks {

    @Inject
    private static Logger logger;

    @Inject
    private UniqueKeyGenerator uniqueKeyGenerator;

    public SrDshrTukiDataSks() {
        super();
    }

    public JT_SiDshrTuki execSi(EditDshrTukiTanKoumokuBean pEditDshrTukiTanKoumokuBean,
        EditDshrTukiDKoumokuBean pEditDshrTukiDKoumokuBean) {

        logger.debug("▽ 保険金給付金Ｄ支払統計データ情報編集 開始");

        JT_SiDshrTuki jtSiDshrTuki = SWAKInjector.getInstance(JT_SiDshrTuki.class);
        Integer renno = 0;
        String skno = "";
        String syono = "";
        Integer seikyuurirekiNo = 0;

        if (pEditDshrTukiTanKoumokuBean.getRenno() == null) {
            renno = SrCommonConstants.DEFAULT_INT_ITI;
        }
        else {
            renno = pEditDshrTukiTanKoumokuBean.getRenno();
        }

        if (pEditDshrTukiTanKoumokuBean.getSkno() == null) {
            skno = SrCommonConstants.DEFAULT_STRING_ZERO_1;
        }
        else {
            skno = pEditDshrTukiTanKoumokuBean.getSkno();
        }

        if (pEditDshrTukiTanKoumokuBean.getSyono() == null) {
            syono = SrCommonConstants.DEFAULT_STRING_ZERO_1;
        }
        else {
            syono = pEditDshrTukiTanKoumokuBean.getSyono();
        }

        if (pEditDshrTukiTanKoumokuBean.getSeikyuurirekiNo() == null) {
            seikyuurirekiNo = SrCommonConstants.DEFAULT_INT_ZERO;
        }
        else {
            seikyuurirekiNo = pEditDshrTukiTanKoumokuBean.getSeikyuurirekiNo();
        }

        if (pEditDshrTukiDKoumokuBean == null) {
            jtSiDshrTuki = null;

            logger.debug("△ 保険金給付金Ｄ支払統計データ情報編集 終了");

            return jtSiDshrTuki;
        }

        jtSiDshrTuki.setDshrtoukeisikibetukey(uniqueKeyGenerator.generateUniqueKey());
        jtSiDshrTuki.setRenno(renno);
        jtSiDshrTuki.setSkno(skno);
        jtSiDshrTuki.setSyono(syono);
        jtSiDshrTuki.setSeikyuurirekino(seikyuurirekiNo);
        jtSiDshrTuki.setHenkousikibetukey(pEditDshrTukiTanKoumokuBean.getHenkousikibetuKey());
        jtSiDshrTuki.setSyoriYmd(pEditDshrTukiTanKoumokuBean.getSyoriYmd());
        jtSiDshrTuki.setSyorikbn(pEditDshrTukiTanKoumokuBean.getSyoriKbn());
        jtSiDshrTuki.setHrkkeiro(pEditDshrTukiTanKoumokuBean.getHrkkeiro());
        jtSiDshrTuki.setSyouhncd(pEditDshrTukiTanKoumokuBean.getSyouhnCd());
        jtSiDshrTuki.setSyouhnsdno(pEditDshrTukiTanKoumokuBean.getSyouhnsdNo());
        jtSiDshrTuki.setKykjyoutai(pEditDshrTukiTanKoumokuBean.getKykjyoutai());
        jtSiDshrTuki.setSyoumetujiyuu(pEditDshrTukiTanKoumokuBean.getSyoumetujiyuu());
        jtSiDshrTuki.setKykymd(pEditDshrTukiTanKoumokuBean.getKykymd());
        jtSiDshrTuki.setYendthnkymd(pEditDshrTukiTanKoumokuBean.getYendthnkymd());
        jtSiDshrTuki.setKihons(pEditDshrTukiTanKoumokuBean.getKihons());
        jtSiDshrTuki.setYoteiriritu(pEditDshrTukiTanKoumokuBean.getYoteiriritu());
        jtSiDshrTuki.setDenymd(pEditDshrTukiTanKoumokuBean.getDenymd());
        jtSiDshrTuki.setSiharaid(pEditDshrTukiTanKoumokuBean.getSiharaid());
        jtSiDshrTuki.setCalckijyunymd(pEditDshrTukiDKoumokuBean.getCalckijyunYmd());
        jtSiDshrTuki.setSyoriymd2(pEditDshrTukiDKoumokuBean.getSyoriYmd2());
        jtSiDshrTuki.setJkipjytym(pEditDshrTukiDKoumokuBean.getJkipjytYm());
        jtSiDshrTuki.setKinoubetukijyunymd(pEditDshrTukiDKoumokuBean.getKinoubetukijyunYmd());
        jtSiDshrTuki.setGengkwari(pEditDshrTukiDKoumokuBean.getGengkwari());
        jtSiDshrTuki.setItibushrgk(pEditDshrTukiDKoumokuBean.getItibushrGk());
        jtSiDshrTuki.setHaitoushrkin(pEditDshrTukiDKoumokuBean.getHaitoushrKin());
        jtSiDshrTuki.setKariwariatedruigk(pEditDshrTukiDKoumokuBean.getKariwariatedruiGk());
        jtSiDshrTuki.setKariwariatedgngkkngk(pEditDshrTukiDKoumokuBean.getKariwariatedgngkknGk());
        jtSiDshrTuki.setKariwariatedshrgk(pEditDshrTukiDKoumokuBean.getKariwariatedshrGk());
        jtSiDshrTuki.setDkeisanhaitoukin(pEditDshrTukiDKoumokuBean.getDkeisanhaitouKin());
        jtSiDshrTuki.setDkeisannaiteikakuteikbn(pEditDshrTukiDKoumokuBean.getDkeisannaiteikakuteiKbn());
        jtSiDshrTuki.setHaitounendo(pEditDshrTukiDKoumokuBean.getHaitounendo());
        jtSiDshrTuki.setHaitoushrkingk(pEditDshrTukiDKoumokuBean.getHaitoushrkinGk());
        jtSiDshrTuki.setKariwariatedganrikindshr(pEditDshrTukiDKoumokuBean.getKariwariatedganrikinDshr());
        jtSiDshrTuki.setTumitated(pEditDshrTukiDKoumokuBean.getTumitated());
        jtSiDshrTuki.setTumitatedmodosimae(pEditDshrTukiDKoumokuBean.getTumitatedModosimae());
        jtSiDshrTuki.setTumitatedmodosigo(pEditDshrTukiDKoumokuBean.getTumitatedModosigo());
        jtSiDshrTuki.setTkbthaitou(pEditDshrTukiDKoumokuBean.getTkbtHaitou());
        jtSiDshrTuki.setHaitounendo2(pEditDshrTukiDKoumokuBean.getHaitounendo2());
        jtSiDshrTuki.setHaitoukinskskbn(pEditDshrTukiDKoumokuBean.getHaitoukinsksKbn());
        jtSiDshrTuki.setHaitoumeisaikbn(pEditDshrTukiDKoumokuBean.getHaitoumeisaikbn());
        jtSiDshrTuki.setFstkariwariatednendo(pEditDshrTukiDKoumokuBean.getFstkariwariatedNendo());
        jtSiDshrTuki.setTounendod(pEditDshrTukiDKoumokuBean.getTounendod());
        jtSiDshrTuki.setNaiteikakuteikbn(pEditDshrTukiDKoumokuBean.getNaiteikakuteiKbn());
        jtSiDshrTuki.setKariwariatedshrymd(pEditDshrTukiDKoumokuBean.getKariwariatedshrYmd());
        jtSiDshrTuki.setKariwariatedruigk2(pEditDshrTukiDKoumokuBean.getKariwariatedruiGk2());
        jtSiDshrTuki.setKariwariatedgngkkngk2(pEditDshrTukiDKoumokuBean.getKariwariatedgngkknGk2());
        jtSiDshrTuki.setKariwariatedshrgk2(pEditDshrTukiDKoumokuBean.getKariwariatedshrGk2());
        jtSiDshrTuki.setTumitatedtumitateymd(pEditDshrTukiDKoumokuBean.getTumitatedtumitateYmd());
        jtSiDshrTuki.setTumitatedskskbn(pEditDshrTukiDKoumokuBean.getTumitatedsksKbn());
        jtSiDshrTuki.setTumitated2(pEditDshrTukiDKoumokuBean.getTumitated2());
        jtSiDshrTuki.setTumitatedshrkrkymd(pEditDshrTukiDKoumokuBean.getTumitatedshrkrkYmd());
        jtSiDshrTuki.setNaiteikakuteikbn2(pEditDshrTukiDKoumokuBean.getNaiteikakuteiKbn2());
        jtSiDshrTuki.setHaitouganrikincalckari(pEditDshrTukiDKoumokuBean.getHaitouganrikincalcKari());
        if (pEditDshrTukiDKoumokuBean.getGanrikincalcKariwariatedRirituLst() != null) {
            if (pEditDshrTukiDKoumokuBean.getGanrikincalcKariwariatedRirituLst().size() > 0) {
                jtSiDshrTuki.setKariwariatedriritu1(pEditDshrTukiDKoumokuBean.getGanrikincalcKariwariatedRirituLst().get(0));
            }
            if (pEditDshrTukiDKoumokuBean.getGanrikincalcKariwariatedRirituLst().size() > 1) {
                jtSiDshrTuki.setKariwariatedriritu2(pEditDshrTukiDKoumokuBean.getGanrikincalcKariwariatedRirituLst().get(1));
            }
        }
        jtSiDshrTuki.setHaitouganrikincalctumi(pEditDshrTukiDKoumokuBean.getHaitouganrikincalcTumi());
        if (pEditDshrTukiDKoumokuBean.getGanrikincalcTumitatedRirituLst() != null) {
            if (pEditDshrTukiDKoumokuBean.getGanrikincalcTumitatedRirituLst().size() > 0) {
                jtSiDshrTuki.setTumitatedriritu1(pEditDshrTukiDKoumokuBean.getGanrikincalcTumitatedRirituLst().get(0));
            }
            if (pEditDshrTukiDKoumokuBean.getGanrikincalcTumitatedRirituLst().size() > 1) {
                jtSiDshrTuki.setTumitatedriritu2(pEditDshrTukiDKoumokuBean.getGanrikincalcTumitatedRirituLst().get(1));
            }
        }
        jtSiDshrTuki.setGyoumuKousinsyaId(pEditDshrTukiTanKoumokuBean.getGyoumuKousinsyaId());
        jtSiDshrTuki.setGyoumuKousinKinou(pEditDshrTukiTanKoumokuBean.getGyoumuKousinKinou());
        jtSiDshrTuki.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

        BizPropertyInitializer.initialize(jtSiDshrTuki);

        logger.debug("△ 保険金給付金Ｄ支払統計データ情報編集 終了");

        return jtSiDshrTuki;
    }

    public IT_KhDshrTuki execKhKsnAri(EditDshrTukiTanKoumokuBean pEditDshrTukiTanKoumokuBean,
        EditDshrTukiDKoumokuBean pEditDshrTukiDKoumokuBean) {

        logger.debug("▽ 契約保全Ｄ支払統計データ情報編集（配当共通計算あり） 開始");

        IT_KhDshrTuki itKhDshrTuki = SWAKInjector.getInstance(IT_KhDshrTuki.class);
        Integer renno = 0;
        String syono = "";

        if (pEditDshrTukiTanKoumokuBean.getRenno() == null) {
            renno = SrCommonConstants.DEFAULT_INT_ITI;
        }
        else {
            renno = pEditDshrTukiTanKoumokuBean.getRenno();
        }

        if (pEditDshrTukiTanKoumokuBean.getSyono() == null) {
            syono = SrCommonConstants.DEFAULT_STRING_ZERO_1;
        }
        else {
            syono = pEditDshrTukiTanKoumokuBean.getSyono();
        }

        if (pEditDshrTukiDKoumokuBean == null) {
            itKhDshrTuki = null;

            logger.debug("△ 契約保全Ｄ支払統計データ情報編集（配当共通計算あり） 終了");

            return itKhDshrTuki;
        }

        itKhDshrTuki.setDshrtoukeisikibetukey(uniqueKeyGenerator.generateUniqueKey());
        itKhDshrTuki.setRenno(renno);
        itKhDshrTuki.setSyono(syono);
        itKhDshrTuki.setHenkousikibetukey(pEditDshrTukiTanKoumokuBean.getHenkousikibetuKey());
        itKhDshrTuki.setSyoriYmd(pEditDshrTukiTanKoumokuBean.getSyoriYmd());
        itKhDshrTuki.setSyorikbn(pEditDshrTukiTanKoumokuBean.getSyoriKbn());
        itKhDshrTuki.setHrkkeiro(pEditDshrTukiTanKoumokuBean.getHrkkeiro());
        itKhDshrTuki.setSyouhncd(pEditDshrTukiTanKoumokuBean.getSyouhnCd());
        itKhDshrTuki.setSyouhnsdno(pEditDshrTukiTanKoumokuBean.getSyouhnsdNo());
        itKhDshrTuki.setKykjyoutai(pEditDshrTukiTanKoumokuBean.getKykjyoutai());
        itKhDshrTuki.setSyoumetujiyuu(pEditDshrTukiTanKoumokuBean.getSyoumetujiyuu());
        itKhDshrTuki.setKykymd(pEditDshrTukiTanKoumokuBean.getKykymd());
        itKhDshrTuki.setYendthnkymd(pEditDshrTukiTanKoumokuBean.getYendthnkymd());
        itKhDshrTuki.setKihons(pEditDshrTukiTanKoumokuBean.getKihons());
        itKhDshrTuki.setYoteiriritu(pEditDshrTukiTanKoumokuBean.getYoteiriritu());
        itKhDshrTuki.setDenymd(pEditDshrTukiTanKoumokuBean.getDenymd());
        itKhDshrTuki.setSiharaid(pEditDshrTukiTanKoumokuBean.getSiharaid());
        itKhDshrTuki.setCalckijyunymd(pEditDshrTukiDKoumokuBean.getCalckijyunYmd());
        itKhDshrTuki.setSyoriymd2(pEditDshrTukiDKoumokuBean.getSyoriYmd2());
        itKhDshrTuki.setJkipjytym(pEditDshrTukiDKoumokuBean.getJkipjytYm());
        itKhDshrTuki.setKinoubetukijyunymd(pEditDshrTukiDKoumokuBean.getKinoubetukijyunYmd());
        itKhDshrTuki.setGengkwari(pEditDshrTukiDKoumokuBean.getGengkwari());
        itKhDshrTuki.setItibushrgk(pEditDshrTukiDKoumokuBean.getItibushrGk());
        itKhDshrTuki.setHaitoushrkin(pEditDshrTukiDKoumokuBean.getHaitoushrKin());
        itKhDshrTuki.setKariwariatedruigk(pEditDshrTukiDKoumokuBean.getKariwariatedruiGk());
        itKhDshrTuki.setKariwariatedgngkkngk(pEditDshrTukiDKoumokuBean.getKariwariatedgngkknGk());
        itKhDshrTuki.setKariwariatedshrgk(pEditDshrTukiDKoumokuBean.getKariwariatedshrGk());
        itKhDshrTuki.setDkeisanhaitoukin(pEditDshrTukiDKoumokuBean.getDkeisanhaitouKin());
        itKhDshrTuki.setDkeisannaiteikakuteikbn(pEditDshrTukiDKoumokuBean.getDkeisannaiteikakuteiKbn());
        itKhDshrTuki.setHaitounendo(pEditDshrTukiDKoumokuBean.getHaitounendo());
        itKhDshrTuki.setHaitoushrkingk(pEditDshrTukiDKoumokuBean.getHaitoushrkinGk());
        itKhDshrTuki.setKariwariatedganrikindshr(pEditDshrTukiDKoumokuBean.getKariwariatedganrikinDshr());
        itKhDshrTuki.setTumitated(pEditDshrTukiDKoumokuBean.getTumitated());
        itKhDshrTuki.setTumitatedmodosimae(pEditDshrTukiDKoumokuBean.getTumitatedModosimae());
        itKhDshrTuki.setTumitatedmodosigo(pEditDshrTukiDKoumokuBean.getTumitatedModosigo());
        itKhDshrTuki.setTkbthaitou(pEditDshrTukiDKoumokuBean.getTkbtHaitou());
        itKhDshrTuki.setHaitounendo2(pEditDshrTukiDKoumokuBean.getHaitounendo2());
        itKhDshrTuki.setHaitoukinskskbn(pEditDshrTukiDKoumokuBean.getHaitoukinsksKbn());
        itKhDshrTuki.setHaitoumeisaikbn(pEditDshrTukiDKoumokuBean.getHaitoumeisaikbn());
        itKhDshrTuki.setFstkariwariatednendo(pEditDshrTukiDKoumokuBean.getFstkariwariatedNendo());
        itKhDshrTuki.setTounendod(pEditDshrTukiDKoumokuBean.getTounendod());
        itKhDshrTuki.setNaiteikakuteikbn(pEditDshrTukiDKoumokuBean.getNaiteikakuteiKbn());
        itKhDshrTuki.setKariwariatedshrymd(pEditDshrTukiDKoumokuBean.getKariwariatedshrYmd());
        itKhDshrTuki.setKariwariatedruigk2(pEditDshrTukiDKoumokuBean.getKariwariatedruiGk2());
        itKhDshrTuki.setKariwariatedgngkkngk2(pEditDshrTukiDKoumokuBean.getKariwariatedgngkknGk2());
        itKhDshrTuki.setKariwariatedshrgk2(pEditDshrTukiDKoumokuBean.getKariwariatedshrGk2());
        itKhDshrTuki.setTumitatedtumitateymd(pEditDshrTukiDKoumokuBean.getTumitatedtumitateYmd());
        itKhDshrTuki.setTumitatedskskbn(pEditDshrTukiDKoumokuBean.getTumitatedsksKbn());
        itKhDshrTuki.setTumitated2(pEditDshrTukiDKoumokuBean.getTumitated2());
        itKhDshrTuki.setTumitatedshrkrkymd(pEditDshrTukiDKoumokuBean.getTumitatedshrkrkYmd());
        itKhDshrTuki.setNaiteikakuteikbn2(pEditDshrTukiDKoumokuBean.getNaiteikakuteiKbn2());
        itKhDshrTuki.setHaitouganrikincalckari(pEditDshrTukiDKoumokuBean.getHaitouganrikincalcKari());
        if (pEditDshrTukiDKoumokuBean.getGanrikincalcKariwariatedRirituLst() != null) {
            if (pEditDshrTukiDKoumokuBean.getGanrikincalcKariwariatedRirituLst().size() > 0) {
                itKhDshrTuki.setKariwariatedriritu1(pEditDshrTukiDKoumokuBean.getGanrikincalcKariwariatedRirituLst().get(0));
            }
            if (pEditDshrTukiDKoumokuBean.getGanrikincalcKariwariatedRirituLst().size() > 1) {
                itKhDshrTuki.setKariwariatedriritu2(pEditDshrTukiDKoumokuBean.getGanrikincalcKariwariatedRirituLst().get(1));
            }
        }
        itKhDshrTuki.setHaitouganrikincalctumi(pEditDshrTukiDKoumokuBean.getHaitouganrikincalcTumi());
        if (pEditDshrTukiDKoumokuBean.getGanrikincalcTumitatedRirituLst() != null) {
            if (pEditDshrTukiDKoumokuBean.getGanrikincalcTumitatedRirituLst().size() > 0) {
                itKhDshrTuki.setTumitatedriritu1(pEditDshrTukiDKoumokuBean.getGanrikincalcTumitatedRirituLst().get(0));
            }
            if (pEditDshrTukiDKoumokuBean.getGanrikincalcTumitatedRirituLst().size() > 1) {
                itKhDshrTuki.setTumitatedriritu2(pEditDshrTukiDKoumokuBean.getGanrikincalcTumitatedRirituLst().get(1));
            }
        }
        itKhDshrTuki.setGyoumuKousinsyaId(pEditDshrTukiTanKoumokuBean.getGyoumuKousinsyaId());
        itKhDshrTuki.setGyoumuKousinKinou(pEditDshrTukiTanKoumokuBean.getGyoumuKousinKinou());
        itKhDshrTuki.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

        BizPropertyInitializer.initialize(itKhDshrTuki);

        logger.debug("△ 契約保全Ｄ支払統計データ情報編集（配当共通計算あり） 終了");

        return itKhDshrTuki;
    }

    public IT_KhDshrTuki execKhKsnNasi(EditDshrTukiTanKoumokuBean pEditDshrTukiTanKoumokuBean) {

        logger.debug("▽ 契約保全Ｄ支払統計データ情報編集（配当共通計算なし） 開始");

        IT_KhHaitouKanri khHaitouKanri = SWAKInjector.getInstance(IT_KhHaitouKanri.class);
        IT_KhTumitateDKanri khTumitateDKanri = SWAKInjector.getInstance(IT_KhTumitateDKanri.class);
        IT_KhDshrTuki itKhDshrTuki = SWAKInjector.getInstance(IT_KhDshrTuki.class);
        Integer renno = 0;
        String syono = "";

        if (pEditDshrTukiTanKoumokuBean.getRenno() == null) {
            renno = SrCommonConstants.DEFAULT_INT_ITI;
        }
        else {
            renno = pEditDshrTukiTanKoumokuBean.getRenno();
        }

        if (pEditDshrTukiTanKoumokuBean.getSyono() == null) {
            syono = SrCommonConstants.DEFAULT_STRING_ZERO_1;
        }
        else {
            syono = pEditDshrTukiTanKoumokuBean.getSyono();
        }

        if (pEditDshrTukiTanKoumokuBean.getKhHaitouKanri() == null &&
            IKhozenCommonConstants.KINOUID_DHANEI.equals(pEditDshrTukiTanKoumokuBean.getGyoumuKousinKinou())) {
            itKhDshrTuki = null;

            logger.debug("△ 契約保全Ｄ支払統計データ情報編集（配当共通計算なし） 終了");

            return itKhDshrTuki;
        }

        khHaitouKanri = pEditDshrTukiTanKoumokuBean.getKhHaitouKanri();

        if (pEditDshrTukiTanKoumokuBean.getKhTumitateDKanri() != null) {
            khTumitateDKanri = pEditDshrTukiTanKoumokuBean.getKhTumitateDKanri();
        }
        itKhDshrTuki.setDshrtoukeisikibetukey(uniqueKeyGenerator.generateUniqueKey());
        itKhDshrTuki.setRenno(renno);
        itKhDshrTuki.setSyono(syono);
        itKhDshrTuki.setHenkousikibetukey(pEditDshrTukiTanKoumokuBean.getHenkousikibetuKey());
        itKhDshrTuki.setSyoriYmd(pEditDshrTukiTanKoumokuBean.getSyoriYmd());
        itKhDshrTuki.setSyorikbn(pEditDshrTukiTanKoumokuBean.getSyoriKbn());
        itKhDshrTuki.setHrkkeiro(pEditDshrTukiTanKoumokuBean.getHrkkeiro());
        itKhDshrTuki.setSyouhncd(pEditDshrTukiTanKoumokuBean.getSyouhnCd());
        itKhDshrTuki.setSyouhnsdno(pEditDshrTukiTanKoumokuBean.getSyouhnsdNo());
        itKhDshrTuki.setKykjyoutai(pEditDshrTukiTanKoumokuBean.getKykjyoutai());
        itKhDshrTuki.setSyoumetujiyuu(pEditDshrTukiTanKoumokuBean.getSyoumetujiyuu());
        itKhDshrTuki.setKykymd(pEditDshrTukiTanKoumokuBean.getKykymd());
        itKhDshrTuki.setYendthnkymd(pEditDshrTukiTanKoumokuBean.getYendthnkymd());
        itKhDshrTuki.setKihons(pEditDshrTukiTanKoumokuBean.getKihons());
        itKhDshrTuki.setYoteiriritu(pEditDshrTukiTanKoumokuBean.getYoteiriritu());
        itKhDshrTuki.setDenymd(pEditDshrTukiTanKoumokuBean.getDenymd());
        if (khHaitouKanri != null) {
            itKhDshrTuki.setHaitounendo2(khHaitouKanri.getHaitounendo());
            itKhDshrTuki.setHaitoukinskskbn(khHaitouKanri.getHaitoukinskskbn());
            itKhDshrTuki.setHaitoumeisaikbn(khHaitouKanri.getHaitoumeisaikbn());
            itKhDshrTuki.setFstkariwariatednendo(khHaitouKanri.getFstkariwariatednendo());
            itKhDshrTuki.setTounendod(khHaitouKanri.getTounendod());
            itKhDshrTuki.setNaiteikakuteikbn(khHaitouKanri.getNaiteikakuteikbn());
            itKhDshrTuki.setKariwariatedshrymd(khHaitouKanri.getKariwariatedshrymd());
            itKhDshrTuki.setKariwariatedruigk2(khHaitouKanri.getKariwariatedruigk());
            itKhDshrTuki.setKariwariatedgngkkngk2(khHaitouKanri.getKariwariatedgngkkngk());
            itKhDshrTuki.setKariwariatedshrgk2(khHaitouKanri.getKariwariatedshrgk());
        }
        itKhDshrTuki.setTumitatedtumitateymd(khTumitateDKanri.getTumitatedtumitateymd());
        itKhDshrTuki.setTumitatedskskbn(khTumitateDKanri.getTumitatedskskbn());
        itKhDshrTuki.setTumitated2(khTumitateDKanri.getTumitated());
        itKhDshrTuki.setTumitatedshrkrkymd(khTumitateDKanri.getTumitatedshrkrkymd());
        itKhDshrTuki.setNaiteikakuteikbn2(khTumitateDKanri.getNaiteikakuteikbn());
        itKhDshrTuki.setGyoumuKousinsyaId(pEditDshrTukiTanKoumokuBean.getGyoumuKousinsyaId());
        itKhDshrTuki.setGyoumuKousinKinou(pEditDshrTukiTanKoumokuBean.getGyoumuKousinKinou());
        itKhDshrTuki.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

        BizPropertyInitializer.initialize(itKhDshrTuki);

        logger.debug("△ 契約保全Ｄ支払統計データ情報編集（配当共通計算なし） 終了");

        return itKhDshrTuki;
    }
}
