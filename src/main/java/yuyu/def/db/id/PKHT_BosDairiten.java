package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.HT_BosDairiten;
import yuyu.def.db.mapping.GenHT_BosDairiten;
import yuyu.def.db.meta.GenQHT_BosDairiten;
import yuyu.def.db.meta.QHT_BosDairiten;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 募集代理店テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_BosDairiten}</td><td colspan="3">募集代理店テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRenno renno}</td><td>連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>bsyujoyadrtencd</td><td>募集時親代理店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>drtensykbn</td><td>代理店種別区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_DrtensyKbn C_DrtensyKbn}</td></tr>
 *  <tr><td>kinyuucd</td><td>金融機関コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kinyuusitencd</td><td>金融機関支店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tratkiagcd</td><td>取扱代理店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>oyadrtencd</td><td>親代理店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>jimusyocd</td><td>事務所コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bosyuutrkno</td><td>募集人登録番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>cifcd</td><td>ＣＩＦコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>drtencd</td><td>代理店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bosyuucd</td><td>募集人コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>inputbosyuucd</td><td>入力募集人コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>daibosyuucd</td><td>代表募集人コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tratkikouinncd</td><td>取扱行員コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>yuuseikbn</td><td>郵政区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YuuseiKbn C_YuuseiKbn}</td></tr>
 *  <tr><td>kyokusyocd</td><td>局所コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>yuuseisyainno</td><td>郵政社員番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bunwari</td><td>分担割合</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_BosDairiten
 * @see     GenHT_BosDairiten
 * @see     QHT_BosDairiten
 * @see     GenQHT_BosDairiten
 */
public class PKHT_BosDairiten extends AbstractExDBPrimaryKey<HT_BosDairiten, PKHT_BosDairiten> {

    private static final long serialVersionUID = 1L;

    public PKHT_BosDairiten() {
    }

    public PKHT_BosDairiten(String pMosno, Integer pRenno) {
        mosno = pMosno;
        renno = pRenno;
    }

    @Transient
    @Override
    public Class<HT_BosDairiten> getEntityClass() {
        return HT_BosDairiten.class;
    }

    private String mosno;

    public String getMosno() {
        return mosno;
    }

    public void setMosno(String pMosno) {
        mosno = pMosno;
    }
    private Integer renno;

    public Integer getRenno() {
        return renno;
    }

    public void setRenno(Integer pRenno) {
        renno = pRenno;
    }

}