package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.JT_Outai;
import yuyu.def.db.mapping.GenJT_Outai;
import yuyu.def.db.meta.GenQJT_Outai;
import yuyu.def.db.meta.QJT_Outai;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 応対テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_Outai}</td><td colspan="3">応対テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRenno renno}</td><td>連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>nayoseyouhi</td><td>名寄せ要否</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NayoseYouhi C_NayoseYouhi}</td></tr>
 *  <tr><td>mousideninkbn</td><td>申出人区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_MousideninKbn C_MousideninKbn}</td></tr>
 *  <tr><td>syuhiyouhi</td><td>守秘要否</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyuhiYouhi C_SyuhiYouhi}</td></tr>
 *  <tr><td>mousideninnmkj</td><td>申出人名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>souhusakikbn</td><td>送付先区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SouhusakiKbn C_SouhusakiKbn}</td></tr>
 *  <tr><td>tsinyno</td><td>通信先郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsinadr1kj</td><td>通信先住所１（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsinadr2kj</td><td>通信先住所２（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsinadr3kj</td><td>通信先住所３（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsintelno</td><td>通信先電話番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>betukyksuu</td><td>別契約数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kossyoricd</td><td>更新処理コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kossyorisscd</td><td>更新処理詳細コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_Outai
 * @see     GenJT_Outai
 * @see     QJT_Outai
 * @see     GenQJT_Outai
 */
public class PKJT_Outai extends AbstractExDBPrimaryKey<JT_Outai, PKJT_Outai> {

    private static final long serialVersionUID = 1L;

    public PKJT_Outai() {
    }

    public PKJT_Outai(String pSyono, Integer pRenno) {
        syono = pSyono;
        renno = pRenno;
    }

    @Transient
    @Override
    public Class<JT_Outai> getEntityClass() {
        return JT_Outai.class;
    }

    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }
    private Integer renno;

    public Integer getRenno() {
        return renno;
    }

    public void setRenno(Integer pRenno) {
        renno = pRenno;
    }

}