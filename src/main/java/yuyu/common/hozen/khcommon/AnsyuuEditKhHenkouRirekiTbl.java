package yuyu.common.hozen.khcommon;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.inject.Inject;

import jp.co.slcs.swak.core.classification.Classification;
import jp.co.slcs.swak.core.resource.ResourceUtil;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.AbstractExDBEntity;
import jp.co.slcs.swak.db.typesafe.ExDBEntity;
import jp.co.slcs.swak.db.util.EntityUtil;

import org.apache.commons.beanutils.PropertyUtilsBean;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_HnkSyuruiKbn;
import yuyu.def.classification.C_KrkriyuuKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_ShrriyuuKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TokusinKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_Kariukekin;
import yuyu.def.db.entity.IT_KhHenkouRireki;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_NyuukinKakusyouData;
import yuyu.def.db.entity.IT_SyuunouHenknRireki;
import yuyu.def.db.entity.IT_Tokusin;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * 契約保全 契約保全共通 案内収納用契約保全変更履歴TBL編集<br />
 * 変更前と変更後のエンティティを比較し、差異がある場合は契約保全変更履歴TBLに登録する。
 */
public class AnsyuuEditKhHenkouRirekiTbl {

    private int renNo;

    private String sysTime;

    private List<IT_KhHenkouRireki> henkouRirekiList;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private HozenDomManager hozenDomManager;

    public AnsyuuEditKhHenkouRirekiTbl() {
        super();
    }

    public List<IT_KhHenkouRireki> editKhHenkouRirekiTblForNyuukin(
        EditKhHenkouRirekiTblForNyuukinBean pEditKhHkRrkTblForNyknBean) {

        renNo = 1;
        sysTime = BizDate.getSysDateTimeMilli();
        henkouRirekiList = new ArrayList<IT_KhHenkouRireki>();

        IT_KykKihon kykKihon = pEditKhHkRrkTblForNyknBean.getKykKihonSyoriAto();
        String syoNo = kykKihon.getSyono();

        IT_KykSyouhn kykSyouhnSyoriAto = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);

        IT_Kariukekin kariukekinSyoriAto = pEditKhHkRrkTblForNyknBean.getKariukekinSyoriAto();

        IT_Tokusin tokusinSyoriAto = hozenDomManager.getAnsyuKihon(syoNo).getTokusin();

        IT_SyuunouHenknRireki syuunouHenknRirekiAto = pEditKhHkRrkTblForNyknBean.getSyuunouHenknRirekiSyoriAto();

        IT_KhTtdkRireki khTtdkRireki =
            kykKihon.getKhTtdkRirekiByHenkousikibetukey(pEditKhHkRrkTblForNyknBean.getHenkouSikibetuKey());

        editHenkouRirekiAnsyuuKihon(
            pEditKhHkRrkTblForNyknBean.getAnsyuKihonSyoriMae(),
            pEditKhHkRrkTblForNyknBean.getAnsyuKihonSyoriAto(),
            khTtdkRireki);

        if (pEditKhHkRrkTblForNyknBean.getNyuukinKakusyouDataSyoriAto() != null) {
            editHenkouRirekiNyuukinKakusyou(
                pEditKhHkRrkTblForNyknBean.getNyuukinKakusyouDataSyoriAto(),
                khTtdkRireki);
        }

        editHenkouRirekiKykSyouhn(
            pEditKhHkRrkTblForNyknBean.getKykSyouhnSyoriMae(),
            kykSyouhnSyoriAto,
            khTtdkRireki);

        editHenkouRirekiKariukekin(
            null,
            kariukekinSyoriAto,
            khTtdkRireki);

        editHenkouRirekiSyuunouHenknRireki(
            null,
            syuunouHenknRirekiAto,
            khTtdkRireki);

        editHenkouRirekiTokusin(
            pEditKhHkRrkTblForNyknBean.getTokusinSyoriMae(),
            tokusinSyoriAto,
            khTtdkRireki);

        return henkouRirekiList;
    }

    private void editHenkouRirekiAnsyuuKihon(IT_AnsyuKihon pAnsyuKihonMae, IT_AnsyuKihon pAnsyuKihonAto,
        IT_KhTtdkRireki pKhTtdkRireki) {

        LinkedList<String[]> henkouList = editHenkouList(pAnsyuKihonMae, pAnsyuKihonAto);

        if (henkouList.size() != 0) {
            editHenkouRrkTblEntityList(
                IT_AnsyuKihon.TABLE_NAME ,
                ResourceUtil.getApplicationResources().getString(IT_AnsyuKihon.TABLE_NAME),
                C_HnkSyuruiKbn.HENKOU,
                "契約基本情報",
                henkouList,
                pKhTtdkRireki);
        }
    }

    private void editHenkouRirekiNyuukinKakusyou(IT_NyuukinKakusyouData pNyuukinKakusyouDataAto,
        IT_KhTtdkRireki pKhTtdkRireki) {

        String hanbetuNm = "入金確証情報（入金確証番号：" + pNyuukinKakusyouDataAto.getNyuukinkakusyouno() + "）";
        String nykkeiro = C_Nykkeiro.getContentByValue(C_Nykkeiro.PATTERN_DISP, pNyuukinKakusyouDataAto.getNykkeiro().getValue());
        String[] henkouArray = {"","","","","",
            "入金伝票日付："     + pNyuukinKakusyouDataAto.getNykdenymd() + "／" +
                "束仮勘定番号：" + pNyuukinKakusyouDataAto.getTabakarikanjyono() + "／" +
                "入金経路：" + nykkeiro + "／" +
                "充当年月：" + convertNullToBlank(pNyuukinKakusyouDataAto.getJyuutouym()) + "／" +
                "充当回数（年）：" + pNyuukinKakusyouDataAto.getJyutoukaisuuy() + "／" +
                "充当回数（月）：" + pNyuukinKakusyouDataAto.getJyutoukaisuum() + "／" +
                "領収日：" + pNyuukinKakusyouDataAto.getRyosyuymd() };

        editHenkouRrkEntity(
            IT_NyuukinKakusyouData.TABLE_NAME ,
            ResourceUtil.getApplicationResources().getString(IT_NyuukinKakusyouData.TABLE_NAME),
            C_HnkSyuruiKbn.TUIKA,
            hanbetuNm,
            henkouArray,
            pKhTtdkRireki);
    }

    private void editHenkouRirekiKykSyouhn(IT_KykSyouhn pKykSyouhnMae, IT_KykSyouhn pKykSyouhnAto,
        IT_KhTtdkRireki pKhTtdkRireki) {

        if (pKykSyouhnMae != null && pKykSyouhnAto != null) {

            LinkedList<String[]> henkouList = editHenkouList(pKykSyouhnMae, pKykSyouhnAto);

            BM_SyouhnZokusei syouhnZokusei =
                bizDomManager.getSyouhnZokusei(pKykSyouhnAto.getSyouhncd(), pKykSyouhnAto.getSyouhnsdno());
            String hanbetuNm = syouhnZokusei.getSyouhnnmryaku();

            if (henkouList.size() != 0) {
                editHenkouRrkTblEntityList(
                    IT_KykSyouhn.TABLE_NAME ,
                    ResourceUtil.getApplicationResources().getString(IT_KykSyouhn.TABLE_NAME),
                    C_HnkSyuruiKbn.HENKOU,
                    hanbetuNm,
                    henkouList,
                    pKhTtdkRireki);
            }
        }
    }

    private void editHenkouRirekiKariukekin(IT_Kariukekin pKariukekinMae, IT_Kariukekin pKariukekinAto,
        IT_KhTtdkRireki pKhTtdkRireki) {

        if (pKariukekinMae == null && pKariukekinAto != null) {

            String hanbetuNm = "仮受金情報（仮受番号：" + pKariukekinAto.getKrkno() + "）";
            String krkriyuukbn = C_KrkriyuuKbn.getContentByValue(pKariukekinAto.getKrkriyuukbn().getValue());
            String nyknaiyouKbn = C_NyknaiyouKbn.getContentByValue(pKariukekinAto.getNyknaiyoukbn().getValue());
            String nykkeiro = C_Nykkeiro.getContentByValue(C_Nykkeiro.PATTERN_DISP, pKariukekinAto.getNykkeiro().getValue());
            String[] henkouArray = {"","","","","",
                "計上日：" + pKariukekinAto.getKrkkeijyoymd() + "／" +
                    "金額：" + pKariukekinAto.getKrkgk() + "／" +
                    "仮受理由：" + subString(krkriyuukbn, 6) + "／" + subString(nyknaiyouKbn, 10) + "／" +
                    "経路：" + subString(nykkeiro, 6) + "／" +
                    "充当年月：" + convertNullToBlank(pKariukekinAto.getJyuutouym()) + "／" +
                    "年数：" + pKariukekinAto.getJyutoukaisuuy() + "／" +
                    "月数：" + pKariukekinAto.getJyutoukaisuum() + "／" +
                    "領収日：" + pKariukekinAto.getRyosyuymd() };

            editHenkouRrkEntity(
                IT_Kariukekin.TABLE_NAME ,
                ResourceUtil.getApplicationResources().getString(IT_Kariukekin.TABLE_NAME),
                C_HnkSyuruiKbn.TUIKA,
                hanbetuNm,
                henkouArray,
                pKhTtdkRireki);
        }
    }

    private void editHenkouRirekiTokusin(IT_Tokusin pTokusinMae, IT_Tokusin pTokusinAto,
        IT_KhTtdkRireki pKhTtdkRireki) {

        if (pTokusinMae != null && pTokusinAto == null) {

            String tokusinkbn = C_TokusinKbn.getContentByValue(pTokusinMae.getTokusinkbn().getValue());
            String tokusinHenkouNaiyou = "";
            if (C_TokusinKbn.HISAIGAI.eq(pTokusinMae.getTokusinkbn())) {
                tokusinHenkouNaiyou = "特伸区分：" + tokusinkbn + "／" +
                    "特伸処理年月日：" + pTokusinMae.getTokusinsyoriymd() + "／" +
                    "特伸終了年月日：" + pTokusinMae.getTokusinendymd() + "／" +
                    "被災害年月日：" + pTokusinMae.getHsgymd();
            }
            else {
                tokusinHenkouNaiyou = "特伸区分：" + tokusinkbn + "／" +
                    "特伸処理年月日：" + pTokusinMae.getTokusinsyoriymd() + "／" +
                    "特伸終了年月日：" + pTokusinMae.getTokusinendymd();
            }
            String[] henkouArray = {"","","",tokusinHenkouNaiyou,"",""};
            editHenkouRrkEntity(
                IT_Tokusin.TABLE_NAME ,
                ResourceUtil.getApplicationResources().getString(IT_Tokusin.TABLE_NAME),
                C_HnkSyuruiKbn.SAKUJYO,
                "特伸情報",
                henkouArray,
                pKhTtdkRireki);
        }
    }

    private void editHenkouRirekiSyuunouHenknRireki(IT_SyuunouHenknRireki pSyuunouHenknRirekiMae,
        IT_SyuunouHenknRireki pSyuunouHenknRirekiAto, IT_KhTtdkRireki pKhTtdkRireki) {

        if (pSyuunouHenknRirekiMae == null && pSyuunouHenknRirekiAto != null) {

            String shrriyuuKbn = C_ShrriyuuKbn.getContentByValue(pSyuunouHenknRirekiAto.getShrriyuukbn().getValue());
            String yokinKbn = C_YokinKbn.getContentByValue(pSyuunouHenknRirekiAto.getYokinkbn().getValue());

            String hanbetuKoumokunm = "収納返金履歴情報（伝票データ連番：" + pSyuunouHenknRirekiAto.getDenrenno() +
                "　枝番号：" + pSyuunouHenknRirekiAto.getEdano() + "）";
            String syuunouHenknRirekiHenkouNaiyou = "";
            if (BizUtil.isBlank(pSyuunouHenknRirekiAto.getCreditkessaiyouno())) {
                syuunouHenknRirekiHenkouNaiyou = "支払日：" + pSyuunouHenknRirekiAto.getShrymd() + "／" +
                    "返金額：" + pSyuunouHenknRirekiAto.getHnkngk() + "／" +
                    "理由：" + subString(shrriyuuKbn, 10) + "／" +
                    "銀行：" + pSyuunouHenknRirekiAto.getBankcd() + "／" +
                    "支店：" + pSyuunouHenknRirekiAto.getSitencd() + "／" +
                    subString(yokinKbn, 2) + "／" +
                    "口座番号：" + pSyuunouHenknRirekiAto.getKouzano() + "／" +
                    subString(pSyuunouHenknRirekiAto.getKzmeiginmkn(), 18);
            }
            else {
                syuunouHenknRirekiHenkouNaiyou = "支払日：" + pSyuunouHenknRirekiAto.getShrymd() + "／" +
                    "返金額：" + pSyuunouHenknRirekiAto.getHnkngk() + "／" +
                    "理由：" + subString(shrriyuuKbn, 10) + "／" +
                    "クレカ決済用番号："+ pSyuunouHenknRirekiAto.getCreditkessaiyouno();
            }
            String[] henkouArray = {"","","","","",syuunouHenknRirekiHenkouNaiyou};
            editHenkouRrkEntity(IT_SyuunouHenknRireki.TABLE_NAME,
                ResourceUtil.getApplicationResources().getString(IT_SyuunouHenknRireki.TABLE_NAME),
                C_HnkSyuruiKbn.TUIKA,
                hanbetuKoumokunm,
                henkouArray,
                pKhTtdkRireki);
        }
    }

    private LinkedList<String[]> editHenkouList(ExDBEntity<?,?> pBeforeEntity, ExDBEntity<?,?> pAfterEntity) {

        LinkedList<String[]> henkouKoumokuList = new LinkedList<String[]>();
        PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();

        try {
            ExDBEntity<?,?> deffEntity = pAfterEntity.getClass().newInstance();
            Set<String> deffKoumokuIdSet = EntityUtil.diffEntitys(pBeforeEntity, pAfterEntity, deffEntity);
            for (String deffKoumokuId:deffKoumokuIdSet ) {

                if (deffKoumokuId.equals(IT_KykKihon.SYONO) ||
                    deffKoumokuId.equals(IT_KykSyouhn.HENKOUSIKIBETUKEY) ||
                    deffKoumokuId.equals(IT_KykKihon.GYOUMUKOUSINKINOU) ||
                    deffKoumokuId.equals(IT_KykKihon.GYOUMUKOUSINSYAID) ||
                    deffKoumokuId.equals(IT_KykKihon.GYOUMUKOUSINTIME) ||
                    deffKoumokuId.equals(IT_KykKihon.KOUSINKINOU) ||
                    deffKoumokuId.equals(IT_KykKihon.KOUSINSYAID) ||
                    deffKoumokuId.equals(IT_KykKihon.KOUSINTIME) ||
                    deffKoumokuId.equals(IT_KykKihon.VERSION)) {
                    continue;
                }

                String koumokuName = ((AbstractExDBEntity<?,?>)pAfterEntity).getFieldViewName(deffKoumokuId);
                Object beforeObject = propertyUtilsBean.getSimpleProperty(pBeforeEntity,deffKoumokuId);
                Object afterObject = propertyUtilsBean.getSimpleProperty(pAfterEntity,deffKoumokuId);
                String beforeValue = "";
                String beforeKbnValue = "";
                String afterValue = "";
                String afterKbnValue = "";

                if (beforeObject != null) {
                    beforeValue = beforeObject.toString();

                    if (beforeObject instanceof Classification) {
                        beforeKbnValue = ((Classification<?>)beforeObject).getContent();
                    }
                    else {
                        beforeKbnValue = beforeObject.toString();
                    }
                }
                if (afterObject != null) {
                    afterValue = afterObject.toString();

                    if (afterObject instanceof Classification) {
                        afterKbnValue = ((Classification<?>)afterObject).getContent();
                    }
                    else {
                        afterKbnValue = afterObject.toString();
                    }
                }

                String[] henkouKoumoku = new String[]{
                    deffKoumokuId, koumokuName, beforeValue, beforeKbnValue, afterValue, afterKbnValue};
                henkouKoumokuList.add(henkouKoumoku);
            }
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        return henkouKoumokuList;
    }

    private void editHenkouRrkTblEntityList(String pTableId, String pTableName, C_HnkSyuruiKbn pHnkSyuruiKbn,
        String pHanbetu, LinkedList<String[]> pHenkouList, IT_KhTtdkRireki pKhTtdkRireki) {

        for (String[] henkouArray : pHenkouList) {
            editHenkouRrkEntity(pTableId, pTableName, pHnkSyuruiKbn, pHanbetu, henkouArray, pKhTtdkRireki);
        }
    }

    private void editHenkouRrkEntity(String pTableId, String pTableName, C_HnkSyuruiKbn pHnkSyuruiKbn,
        String pHanbetu, String[] pHenkouArray, IT_KhTtdkRireki pKhTtdkRireki) {

        IT_KhHenkouRireki khHenkouRireki = pKhTtdkRireki.createKhHenkouRireki();

        khHenkouRireki.setRenno3keta(renNo++);
        khHenkouRireki.setTablenm(pTableName);
        khHenkouRireki.setTableid(pTableId);
        khHenkouRireki.setHnksyuruikbn(pHnkSyuruiKbn);
        khHenkouRireki.setHanbetukoumokunm(pHanbetu);
        khHenkouRireki.setHenkoukoumokuid(pHenkouArray[0]);
        khHenkouRireki.setHenkoukoumokunm(pHenkouArray[1]);
        khHenkouRireki.setBfrnaiyouoriginal(pHenkouArray[2]);
        khHenkouRireki.setBfrnaiyou(pHenkouArray[3]);
        khHenkouRireki.setNewnaiyouoriginal(pHenkouArray[4]);
        khHenkouRireki.setNewnaiyou(pHenkouArray[5]);
        khHenkouRireki.setGyoumuKousinKinou(pKhTtdkRireki.getGyoumuKousinKinou());
        khHenkouRireki.setGyoumuKousinsyaId(pKhTtdkRireki.getGyoumuKousinsyaId());
        khHenkouRireki.setGyoumuKousinTime(sysTime);

        henkouRirekiList.add(khHenkouRireki);
    }

    private String subString(String pMojiretu, int pMaxIndex) {

        String mojiretu = pMojiretu;

        if(mojiretu.length() >= pMaxIndex){

            mojiretu = mojiretu.substring(0, pMaxIndex);
        }

        return mojiretu;
    }

    private String convertNullToBlank(Object pObj) {
        return Objects.toString(pObj, "");
    }
}
