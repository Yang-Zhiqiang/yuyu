package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_IsaToukeiDataRn;
import yuyu.def.db.mapping.GenZT_IsaToukeiDataRn;
import yuyu.def.db.meta.GenQZT_IsaToukeiDataRn;
import yuyu.def.db.meta.QZT_IsaToukeiDataRn;

/**
 * 医査統計データテーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_IsaToukeiDataRn}</td><td colspan="3">医査統計データテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnmosno zrnmosno}</td><td>（連携用）申込番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyono</td><td>（連携用）証券番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhjykktkbn</td><td>（連携用）報状告知区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhknsyuruicd</td><td>（連携用）保険種類コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrkhuhukbn</td><td>（連携用）払込方法区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmossyoumetukbn</td><td>（連携用）申込消滅区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmusymd</td><td>（連携用）申込年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmosym</td><td>（連携用）申込月度</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbsyym</td><td>（連携用）募集年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnaatukaisosikicd</td><td>（連携用）Ａ扱者組織コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnaatukaikojincd</td><td>（連携用）Ａ扱者個人コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknnen3</td><td>（連携用）被保険者年令（３文字）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknseikbn</td><td>（連携用）被保険者性別区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkyktuuka</td><td>（連携用）契約通貨</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsibous7</td><td>（連携用）死亡Ｓ（７桁）</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrndakuhikettisyacd</td><td>（連携用）諾否決定者コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndkhktiymd</td><td>（連携用）諾否決定年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndakuhikettikekkacd</td><td>（連携用）諾否決定結果コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndakuhiketteiriyuucdx1</td><td>（連携用）諾否決定理由コード＿１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndakuhiketteiriyuucdx2</td><td>（連携用）諾否決定理由コード＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndakuhiketteiriyuucdx3</td><td>（連携用）諾否決定理由コード＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndakuhiketteiriyuucdx4</td><td>（連携用）諾否決定理由コード＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyukykktkekkacd</td><td>（連携用）主契約決定結果コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsntyo3</td><td>（連携用）身長（３文字）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntijyuu3</td><td>（連携用）体重（３文字）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbmi</td><td>（連携用）ＢＭＩ</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnsinsahouhou</td><td>（連携用）診査方法</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyoubyoucd1</td><td>（連携用）傷病コード１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkeikanensuux1</td><td>（連携用）経過年数＿１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyoubyoucd2</td><td>（連携用）傷病コード２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkeikanensuux2</td><td>（連携用）経過年数＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyokaiktisinsahouhou</td><td>（連携用）初回決定時診査方法</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyokaiktidkhktikekkacd</td><td>（連携用）初回決定時諾否決定結果コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyokaiktsyukykktkekkacd</td><td>（連携用）初回決定主契約決定結果コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhanbaikeirokbn</td><td>（連携用）販売経路区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnjissituhosyous</td><td>（連携用）実質保障Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnoyadairitencd</td><td>（連携用）親代理店コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnensyuukbn</td><td>（連携用）年収区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsykgycd</td><td>（連携用）職業コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyksbyensitihsyutyhkumu</td><td>（連携用）初期死亡時円換算最低保証特約付加有無</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnjyudkaigomehrtkhkumu</td><td>（連携用）重度介護前払特約付加有無</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykymd</td><td>（連携用）契約年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnijitoukeizennoukbn</td><td>（連携用）医事統計用前納区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndai1hknkkn</td><td>（連携用）第１保険期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnijitoukeitikshrtkykkbn</td><td>（連携用）医事統計用定期支払特約区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnteikisiharaikinmanen</td><td>（連携用）定期支払金（万円）</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnyobiv45</td><td>（連携用）予備項目Ｖ４５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_IsaToukeiDataRn
 * @see     GenZT_IsaToukeiDataRn
 * @see     QZT_IsaToukeiDataRn
 * @see     GenQZT_IsaToukeiDataRn
 */
public class PKZT_IsaToukeiDataRn extends AbstractExDBPrimaryKey<ZT_IsaToukeiDataRn, PKZT_IsaToukeiDataRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_IsaToukeiDataRn() {
    }

    public PKZT_IsaToukeiDataRn(String pZrnmosno) {
        zrnmosno = pZrnmosno;
    }

    @Transient
    @Override
    public Class<ZT_IsaToukeiDataRn> getEntityClass() {
        return ZT_IsaToukeiDataRn.class;
    }

    private String zrnmosno;

    public String getZrnmosno() {
        return zrnmosno;
    }

    public void setZrnmosno(String pZrnmosno) {
        zrnmosno = pZrnmosno;
    }

}