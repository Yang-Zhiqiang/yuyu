package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.mapping.GenAS_Kinou;
import yuyu.def.db.meta.GenQAS_Kinou;
import yuyu.def.db.meta.QAS_Kinou;

/**
 * 機能基幹テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AS_Kinou}</td><td colspan="3">機能基幹テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKinouId kinouId}</td><td>機能ＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>subSystemId</td><td>サブシステムＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>categoryId</td><td>カテゴリＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kinouNm</td><td>機能名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sortNo</td><td>ソート番号</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kinouKbn</td><td>機能区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KinouKbn C_KinouKbn}</td></tr>
 *  <tr><td>jikkouPath</td><td>実行パス</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kinouSetumei</td><td>機能説明</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>batchKyouseiSyuuryouFlag</td><td>バッチ強制終了フラグ</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_BatchKyouseiSyuuryouFlag C_BatchKyouseiSyuuryouFlag}</td></tr>
 *  <tr><td>menuHyoujiKahi</td><td>メニュー表示可否</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KahiKbn C_KahiKbn}</td></tr>
 *  <tr><td>batchLogHyoujiKbn</td><td>バッチログ表示区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_BatchLogHyoujiKbn C_BatchLogHyoujiKbn}</td></tr>
 *  <tr><td>kidouKengenHanteiYouhiKbn</td><td>起動権限判定要否区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YouhiKbn C_YouhiKbn}</td></tr>
 *  <tr><td>kinouTeigiTaisyouKbn</td><td>機能定義対象区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TaisyouKbn C_TaisyouKbn}</td></tr>
 *  <tr><td>syoricd</td><td>処理コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     AS_Kinou
 * @see     GenAS_Kinou
 * @see     QAS_Kinou
 * @see     GenQAS_Kinou
 */
public class PKAS_Kinou extends AbstractExDBPrimaryKey<AS_Kinou, PKAS_Kinou> {

    private static final long serialVersionUID = 1L;

    public PKAS_Kinou() {
    }

    public PKAS_Kinou(String pKinouId) {
        kinouId = pKinouId;
    }

    @Transient
    @Override
    public Class<AS_Kinou> getEntityClass() {
        return AS_Kinou.class;
    }

    private String kinouId;

    public String getKinouId() {
        return kinouId;
    }

    public void setKinouId(String pKinouId) {
        kinouId = pKinouId;
    }

}