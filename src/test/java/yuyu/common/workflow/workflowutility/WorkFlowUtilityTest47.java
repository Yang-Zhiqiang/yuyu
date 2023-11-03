package yuyu.common.workflow.workflowutility;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.List;

import jp.co.slcs.swak.date.BizDate;

import org.junit.Test;

import yuyu.testinfr.TestOrder;

/**
 * ワークフロー呼出ユーティリティクラスのメソッド {@link WorkFlowUtility#GetSumiTaskByUser(String pSubsystemId, BizDate pSyoriYmdFrom, BizDate pSyoriYmdTo, String pUserId)}テスト用クラスです<br />
 */
public class WorkFlowUtilityTest47 {

    @Test
    @TestOrder(10)
    public void testGetSumiTaskByUser_A1() {

        GetSumiTaskByUserResultBean ret = WorkFlowUtility.getSumiTaskByUser(
            "siharai", "59010401", BizDate.valueOf(20200324), BizDate.valueOf(20200324));
        exStringEquals(ret.getSyorikekkaStatus(), "-1", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessage(), null, "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), null, "詳細メッセージ");
        List<GetSumiTaskByUserResultBean> getSumiTaskByUserResultBeanLst =
            ret.getSumiTaskBeanList();
        exNumericEquals(getSumiTaskByUserResultBeanLst.size(), 0, "件数");
    }

    @Test
    @TestOrder(20)
    public void testGetSumiTaskByUser_A2() {

        GetSumiTaskByUserResultBean ret = WorkFlowUtility.getSumiTaskByUser(
            "hozen", "59010501", BizDate.valueOf(20200324), BizDate.valueOf(20200324));
        exStringEquals(ret.getSyorikekkaStatus(), "-1", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessage(), null, "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), null, "詳細メッセージ");
        List<GetSumiTaskByUserResultBean> getSumiTaskByUserResultBeanLst = ret.getSumiTaskBeanList();
        exNumericEquals(getSumiTaskByUserResultBeanLst.size(), 0, "件数");
    }

    @Test
    @TestOrder(30)
    public void testGetSumiTaskByUser_A3() {

        GetSumiTaskByUserResultBean ret = WorkFlowUtility.getSumiTaskByUser(
            "hozen", "55180304", BizDate.valueOf(20200326), BizDate.valueOf(20200326));
        exStringEquals(ret.getSyorikekkaStatus(), "9", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessage(), null, "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), null, "詳細メッセージ");
        List<GetSumiTaskByUserResultBean> getSumiTaskByUserResultBeanLst = ret.getSumiTaskBeanList();
        exNumericEquals(getSumiTaskByUserResultBeanLst.size(), 0, "件数");
    }

    @Test
    @TestOrder(40)
    public void testGetSumiTaskByUser_A4() {

        GetSumiTaskByUserResultBean ret = WorkFlowUtility.getSumiTaskByUser(
            "sinkeiyaku", "56510403", BizDate.valueOf(20200325), BizDate.valueOf(20200325));
        exStringEquals(ret.getSyorikekkaStatus(), "0", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessage(), null, "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), null, "詳細メッセージ");
        List<GetSumiTaskByUserResultBean> getSumiTaskByUserResultBeanLst = ret.getSumiTaskBeanList();
        exNumericEquals(getSumiTaskByUserResultBeanLst.size(), 1, "件数");

        exStringEquals(getSumiTaskByUserResultBeanLst.get(0).getJimutetuzukinm(), "新契約（代理店）", "事務手続名");
        exStringEquals(getSumiTaskByUserResultBeanLst.get(0).getGyoumuKey(), "860209006", "申込番号");
        exStringEquals(getSumiTaskByUserResultBeanLst.get(0).getSyoritime(), "2020/03/25 11:44:54", "処理時間");
        exStringEquals(getSumiTaskByUserResultBeanLst.get(0).getTasknm(), "ｓｔａｔｅ－ｓａｔｅｉ", "タスク名");
        exStringEquals(getSumiTaskByUserResultBeanLst.get(0).getHknsyuruiworklist(), "３２２", "保険種類");
        exStringEquals(getSumiTaskByUserResultBeanLst.get(0).getTratkiagnm1(), "２１０１０７９", "代理店名");
        exStringEquals(getSumiTaskByUserResultBeanLst.get(0).getKyknmkn(), "", "契約者名（カナ）");
        exStringEquals(getSumiTaskByUserResultBeanLst.get(0).getKyknmkj(), "", "契約者名（漢字）");
    }

    @Test
    @TestOrder(50)
    public void testGetSumiTaskByUser_A5() {

        GetSumiTaskByUserResultBean ret = WorkFlowUtility.getSumiTaskByUser(
            "sinkeiyaku", "56550306", BizDate.valueOf(20200323), BizDate.valueOf(20200323));
        exStringEquals(ret.getSyorikekkaStatus(), "0", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessage(), null, "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), null, "詳細メッセージ");
        List<GetSumiTaskByUserResultBean> getSumiTaskByUserResultBeanLst =
            ret.getSumiTaskBeanList();
        exNumericEquals(getSumiTaskByUserResultBeanLst.size(), 1, "件数");

        exStringEquals(getSumiTaskByUserResultBeanLst.get(0).getJimutetuzukinm(), "新契約（代理店）", "事務手続名");
        exStringEquals(getSumiTaskByUserResultBeanLst.get(0).getGyoumuKey(), "860208974", "申込番号");
        exStringEquals(getSumiTaskByUserResultBeanLst.get(0).getSyoritime(), "2020/03/23 11:30:15", "処理時間");
        exStringEquals(getSumiTaskByUserResultBeanLst.get(0).getTasknm(), "ｓｔａｔｅ－ｓｅｉｒｉｔｕ", "タスク名");
        exStringEquals(getSumiTaskByUserResultBeanLst.get(0).getHknsyuruiworklist(), "ふるＪグロⅡ", "保険種類");
        exStringEquals(getSumiTaskByUserResultBeanLst.get(0).getTratkiagnm1(), "漢字代理店正式名５２０００１５", "代理店名");
        exStringEquals(getSumiTaskByUserResultBeanLst.get(0).getKyknmkn(), "ホゼン　マタギテストイチ", "契約者名（カナ）");
        exStringEquals(getSumiTaskByUserResultBeanLst.get(0).getKyknmkj(), "保全　跨ぎ検証一", "契約者名（漢字）");
    }

    @Test
    @TestOrder(60)
    public void testGetSumiTaskByUser_A6() {

        GetSumiTaskByUserResultBean ret = WorkFlowUtility.getSumiTaskByUser(
            "sinkeiyaku", "56510104", BizDate.valueOf(20200323), BizDate.valueOf(20200323));
        exStringEquals(ret.getSyorikekkaStatus(), "0", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessage(), null, "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), null, "詳細メッセージ");
        List<GetSumiTaskByUserResultBean> getSumiTaskByUserResultBeanLst =
            ret.getSumiTaskBeanList();
        exNumericEquals(getSumiTaskByUserResultBeanLst.size(), 1, "件数");

        exStringEquals(getSumiTaskByUserResultBeanLst.get(0).getJimutetuzukinm(), "新契約（代理店）", "事務手続名");
        exStringEquals(getSumiTaskByUserResultBeanLst.get(0).getGyoumuKey(), "860208982", "申込番号");
        exStringEquals(getSumiTaskByUserResultBeanLst.get(0).getSyoritime(), "2020/03/23 16:02:14", "処理時間");
        exStringEquals(getSumiTaskByUserResultBeanLst.get(0).getTasknm(), "申込点検待ち", "タスク名");
        exStringEquals(getSumiTaskByUserResultBeanLst.get(0).getHknsyuruiworklist(), "３２２", "保険種類");
        exStringEquals(getSumiTaskByUserResultBeanLst.get(0).getTratkiagnm1(), "漢字代理店正式名３０００８９６", "代理店名");
        exStringEquals(getSumiTaskByUserResultBeanLst.get(0).getKyknmkn(), "ケイメイ　ゼロゼロゼロ", "契約者名（カナ）");
        exStringEquals(getSumiTaskByUserResultBeanLst.get(0).getKyknmkj(), "契名　零零零", "契約者名（漢字）");
    }

    @Test
    @TestOrder(70)
    public void testGetSumiTaskByUser_A7() {

        GetSumiTaskByUserResultBean ret = WorkFlowUtility.getSumiTaskByUser(
            "sinkeiyaku", "56510303", BizDate.valueOf(20200323), BizDate.valueOf(20200323));
        exStringEquals(ret.getSyorikekkaStatus(), "0", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessage(), null, "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), null, "詳細メッセージ");
        List<GetSumiTaskByUserResultBean> getSumiTaskByUserResultBeanLst =
            ret.getSumiTaskBeanList();
        exNumericEquals(getSumiTaskByUserResultBeanLst.size(), 1, "件数");

        exStringEquals(getSumiTaskByUserResultBeanLst.get(0).getJimutetuzukinm(), "新契約（代理店）", "事務手続名");
        exStringEquals(getSumiTaskByUserResultBeanLst.get(0).getGyoumuKey(), "860208990", "申込番号");
        exStringEquals(getSumiTaskByUserResultBeanLst.get(0).getSyoritime(), "2020/03/23 12:08:16", "処理時間");
        exStringEquals(getSumiTaskByUserResultBeanLst.get(0).getTasknm(), "申込書入力待ち", "タスク名");
        exStringEquals(getSumiTaskByUserResultBeanLst.get(0).getHknsyuruiworklist(), "たのしみ未来Ｇ", "保険種類");
        exStringEquals(getSumiTaskByUserResultBeanLst.get(0).getTratkiagnm1(), "５２０９４０３", "代理店名");
        exStringEquals(getSumiTaskByUserResultBeanLst.get(0).getKyknmkn(), "ケイメイ　ゼロゼロロク", "契約者名（カナ）");
        exStringEquals(getSumiTaskByUserResultBeanLst.get(0).getKyknmkj(), "契名　零零六", "契約者名（漢字）");
    }

    @Test
    @TestOrder(80)
    public void testGetSumiTaskByUser_A8() {

        GetSumiTaskByUserResultBean ret = WorkFlowUtility.getSumiTaskByUser(
            "sinkeiyaku", "56580510", BizDate.valueOf(20200323), BizDate.valueOf(20200323));
        exStringEquals(ret.getSyorikekkaStatus(), "0", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessage(), null, "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), null, "詳細メッセージ");
        List<GetSumiTaskByUserResultBean> getSumiTaskByUserResultBeanLst =
            ret.getSumiTaskBeanList();
        exNumericEquals(getSumiTaskByUserResultBeanLst.size(), 1, "件数");

        exStringEquals(getSumiTaskByUserResultBeanLst.get(0).getJimutetuzukinm(), "新契約（代理店）", "事務手続名");
        exStringEquals(getSumiTaskByUserResultBeanLst.get(0).getGyoumuKey(), "860209022", "申込番号");
        exStringEquals(getSumiTaskByUserResultBeanLst.get(0).getSyoritime(), "2020/03/23 15:42:32", "処理時間");
        exStringEquals(getSumiTaskByUserResultBeanLst.get(0).getTasknm(), "申込点検待ち", "タスク名");
        exStringEquals(getSumiTaskByUserResultBeanLst.get(0).getHknsyuruiworklist(), "たのしみ未来Ｇ", "保険種類");
        exStringEquals(getSumiTaskByUserResultBeanLst.get(0).getTratkiagnm1(), "漢字代理店正式名５３０２５５４", "代理店名");
        exStringEquals(getSumiTaskByUserResultBeanLst.get(0).getKyknmkn(), "", "契約者名（カナ）");
        exStringEquals(getSumiTaskByUserResultBeanLst.get(0).getKyknmkj(), "", "契約者名（漢字）");
    }

    @Test
    @TestOrder(90)
    public void testGetSumiTaskByUser_A9() {

        GetSumiTaskByUserResultBean ret = WorkFlowUtility.getSumiTaskByUser(
            "sinkeiyaku", "56510509", BizDate.valueOf(20200324), BizDate.valueOf(20200324));
        exStringEquals(ret.getSyorikekkaStatus(), "0", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessage(), null, "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), null, "詳細メッセージ");
        List<GetSumiTaskByUserResultBean> getSumiTaskByUserResultBeanLst =
            ret.getSumiTaskBeanList();
        exNumericEquals(getSumiTaskByUserResultBeanLst.size(), 1, "件数");

        exStringEquals(getSumiTaskByUserResultBeanLst.get(0).getJimutetuzukinm(), "新契約（代理店）", "事務手続名");
        exStringEquals(getSumiTaskByUserResultBeanLst.get(0).getGyoumuKey(), "970054706", "申込番号");
        exStringEquals(getSumiTaskByUserResultBeanLst.get(0).getSyoritime(), "2020/03/24 15:29:56", "処理時間");
        exStringEquals(getSumiTaskByUserResultBeanLst.get(0).getTasknm(), "申込書入力待ち", "タスク名");
        exStringEquals(getSumiTaskByUserResultBeanLst.get(0).getHknsyuruiworklist(), "ふるＪグロⅡ", "保険種類");
        exStringEquals(getSumiTaskByUserResultBeanLst.get(0).getTratkiagnm1(), "漢字代理店正式名５１００００１", "代理店名");
        exStringEquals(getSumiTaskByUserResultBeanLst.get(0).getKyknmkn(), "ヒメイ　ソツウイチ", "契約者名（カナ）");
        exStringEquals(getSumiTaskByUserResultBeanLst.get(0).getKyknmkj(), "被名　疎通一", "契約者名（漢字）");
    }

    @Test
    @TestOrder(100)
    public void testGetSumiTaskByUser_A10() {

        GetSumiTaskByUserResultBean ret = WorkFlowUtility.getSumiTaskByUser(
            "hozen", "72720201", BizDate.valueOf(20200323), BizDate.valueOf(20200323));
        exStringEquals(ret.getSyorikekkaStatus(), "0", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessage(), null, "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), null, "詳細メッセージ");
        List<GetSumiTaskByUserResultBean> getSumiTaskByUserResultBeanLst =
            ret.getSumiTaskBeanList();
        exNumericEquals(getSumiTaskByUserResultBeanLst.size(), 1, "件数");

        exStringEquals(getSumiTaskByUserResultBeanLst.get(0).getJimutetuzukinm(), "減額", "事務手続名");
        exStringEquals(getSumiTaskByUserResultBeanLst.get(0).getGyoumuKey(), "99806030605", "申込番号");
        exStringEquals(getSumiTaskByUserResultBeanLst.get(0).getSyoritime(), "2020/03/23 10:59:34", "処理時間");
        exStringEquals(getSumiTaskByUserResultBeanLst.get(0).getTasknm(), "ｉｎｐｕｔ", "タスク名");
        exStringEquals(getSumiTaskByUserResultBeanLst.get(0).getHknsyuruiworklist(), "", "保険種類");
        exStringEquals(getSumiTaskByUserResultBeanLst.get(0).getKyknmkn(), "", "契約者名（カナ）");
        exStringEquals(getSumiTaskByUserResultBeanLst.get(0).getKyknmkj(), "", "契約者名（漢字）");
    }

    @Test
    @TestOrder(110)
    public void testGetSumiTaskByUser_A11() {

        GetSumiTaskByUserResultBean ret = WorkFlowUtility.getSumiTaskByUser(
            "hozen", "71920110", BizDate.valueOf(20200323), BizDate.valueOf(20200323));
        exStringEquals(ret.getSyorikekkaStatus(), "0", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessage(), null, "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), null, "詳細メッセージ");
        List<GetSumiTaskByUserResultBean> getSumiTaskByUserResultBeanLst =
            ret.getSumiTaskBeanList();
        exNumericEquals(getSumiTaskByUserResultBeanLst.size(), 1, "件数");

        exStringEquals(getSumiTaskByUserResultBeanLst.get(0).getJimutetuzukinm(), "被保険者代理特約中途付加", "事務手続名");
        exStringEquals(getSumiTaskByUserResultBeanLst.get(0).getGyoumuKey(), "99806022062", "申込番号");
        exStringEquals(getSumiTaskByUserResultBeanLst.get(0).getSyoritime(), "2020/03/23 14:11:37", "処理時間");
        exStringEquals(getSumiTaskByUserResultBeanLst.get(0).getTasknm(), "点検", "タスク名");
        exStringEquals(getSumiTaskByUserResultBeanLst.get(0).getHknsyuruiworklist(), "", "保険種類");
        exStringEquals(getSumiTaskByUserResultBeanLst.get(0).getKyknmkn(), "シケイメイ　ナナロクア", "契約者名（カナ）");
        exStringEquals(getSumiTaskByUserResultBeanLst.get(0).getKyknmkj(), "シ契名　七六あ", "契約者名（漢字）");
    }


    @Test
    @TestOrder(120)
    public void testGetSumiTaskByUser_A12() {

        GetSumiTaskByUserResultBean ret = WorkFlowUtility.getSumiTaskByUser(
            "hozen", "71920106", BizDate.valueOf(20200323), BizDate.valueOf(20200323));
        exStringEquals(ret.getSyorikekkaStatus(), "0", "処理結果ステータス");
        exStringEquals(ret.getSyousaiMessage(), null, "詳細メッセージコード");
        exStringEquals(ret.getSyousaiMessage(), null, "詳細メッセージ");
        List<GetSumiTaskByUserResultBean> getSumiTaskByUserResultBeanLst =
            ret.getSumiTaskBeanList();
        exNumericEquals(getSumiTaskByUserResultBeanLst.size(), 1, "件数");

        exStringEquals(getSumiTaskByUserResultBeanLst.get(0).getJimutetuzukinm(), "名義変更／契約者等生年月日訂正", "事務手続名");
        exStringEquals(getSumiTaskByUserResultBeanLst.get(0).getGyoumuKey(), "99806003218", "申込番号");
        exStringEquals(getSumiTaskByUserResultBeanLst.get(0).getSyoritime(), "2020/03/23 11:47:40", "処理時間");
        exStringEquals(getSumiTaskByUserResultBeanLst.get(0).getTasknm(), "請求書作成", "タスク名");
        exStringEquals(getSumiTaskByUserResultBeanLst.get(0).getHknsyuruiworklist(), "米ドル終身", "保険種類");
        exStringEquals(getSumiTaskByUserResultBeanLst.get(0).getKyknmkn(), "ヘンコウゴ　ケイヤクシヤ", "契約者名（カナ）");
        exStringEquals(getSumiTaskByUserResultBeanLst.get(0).getKyknmkj(), "変更後　契約者", "契約者名（漢字）");
    }

}
