package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_IsaToukeiDataTy;
import yuyu.def.db.mapping.GenZT_IsaToukeiDataTy;
import yuyu.def.db.meta.GenQZT_IsaToukeiDataTy;
import yuyu.def.db.meta.QZT_IsaToukeiDataTy;

/**
 * 医査統計データテーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_IsaToukeiDataTy}</td><td colspan="3">医査統計データテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtymosno ztymosno}</td><td>（中継用）申込番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyono</td><td>（中継用）証券番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhjykktkbn</td><td>（中継用）報状告知区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhknsyuruicd</td><td>（中継用）保険種類コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkhuhukbn</td><td>（中継用）払込方法区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymossyoumetukbn</td><td>（中継用）申込消滅区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymusymd</td><td>（中継用）申込年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymosym</td><td>（中継用）申込月度</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybsyym</td><td>（中継用）募集年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyaatukaisosikicd</td><td>（中継用）Ａ扱者組織コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyaatukaikojincd</td><td>（中継用）Ａ扱者個人コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknnen3</td><td>（中継用）被保険者年令（３文字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknseikbn</td><td>（中継用）被保険者性別区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyktuuka</td><td>（中継用）契約通貨</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysibous7</td><td>（中継用）死亡Ｓ（７桁）</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztydakuhikettisyacd</td><td>（中継用）諾否決定者コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydkhktiymd</td><td>（中継用）諾否決定年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydakuhikettikekkacd</td><td>（中継用）諾否決定結果コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydakuhiketteiriyuucdx1</td><td>（中継用）諾否決定理由コード＿１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydakuhiketteiriyuucdx2</td><td>（中継用）諾否決定理由コード＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydakuhiketteiriyuucdx3</td><td>（中継用）諾否決定理由コード＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydakuhiketteiriyuucdx4</td><td>（中継用）諾否決定理由コード＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyukykktkekkacd</td><td>（中継用）主契約決定結果コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysntyo3</td><td>（中継用）身長（３文字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytijyuu3</td><td>（中継用）体重（３文字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybmi</td><td>（中継用）ＢＭＩ</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztysinsahouhou</td><td>（中継用）診査方法</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyoubyoucd1</td><td>（中継用）傷病コード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeikanensuux1</td><td>（中継用）経過年数＿１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyoubyoucd2</td><td>（中継用）傷病コード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeikanensuux2</td><td>（中継用）経過年数＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyokaiktisinsahouhou</td><td>（中継用）初回決定時診査方法</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyokaiktidkhktikekkacd</td><td>（中継用）初回決定時諾否決定結果コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyokaiktsyukykktkekkacd</td><td>（中継用）初回決定主契約決定結果コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhanbaikeirokbn</td><td>（中継用）販売経路区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyjissituhosyous</td><td>（中継用）実質保障Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztyoyadairitencd</td><td>（中継用）親代理店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynensyuukbn</td><td>（中継用）年収区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysykgycd</td><td>（中継用）職業コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyksbyensitihsyutyhkumu</td><td>（中継用）初期死亡時円換算最低保証特約付加有無</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyjyudkaigomehrtkhkumu</td><td>（中継用）重度介護前払特約付加有無</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykymd</td><td>（中継用）契約年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyijitoukeizennoukbn</td><td>（中継用）医事統計用前納区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydai1hknkkn</td><td>（中継用）第１保険期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyijitoukeitikshrtkykkbn</td><td>（中継用）医事統計用定期支払特約区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyteikisiharaikinmanen</td><td>（中継用）定期支払金（万円）</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztyyobiv45</td><td>（中継用）予備項目Ｖ４５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_IsaToukeiDataTy
 * @see     GenZT_IsaToukeiDataTy
 * @see     QZT_IsaToukeiDataTy
 * @see     GenQZT_IsaToukeiDataTy
 */
public class PKZT_IsaToukeiDataTy extends AbstractExDBPrimaryKey<ZT_IsaToukeiDataTy, PKZT_IsaToukeiDataTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_IsaToukeiDataTy() {
    }

    public PKZT_IsaToukeiDataTy(String pZtymosno) {
        ztymosno = pZtymosno;
    }

    @Transient
    @Override
    public Class<ZT_IsaToukeiDataTy> getEntityClass() {
        return ZT_IsaToukeiDataTy.class;
    }

    private String ztymosno;

    public String getZtymosno() {
        return ztymosno;
    }

    public void setZtymosno(String pZtymosno) {
        ztymosno = pZtymosno;
    }

}