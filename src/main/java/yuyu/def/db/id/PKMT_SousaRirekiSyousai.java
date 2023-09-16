package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.MT_SousaRirekiSyousai;
import yuyu.def.db.mapping.GenMT_SousaRirekiSyousai;
import yuyu.def.db.meta.GenQMT_SousaRirekiSyousai;
import yuyu.def.db.meta.QMT_SousaRirekiSyousai;

/**
 * 操作履歴詳細テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link MT_SousaRirekiSyousai}</td><td colspan="3">操作履歴詳細テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getTtdksikibetuid ttdksikibetuid}</td><td>手続識別ＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSousarirekirenno sousarirekirenno}</td><td>操作履歴連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>syoriendymd</td><td>処理終了日付</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>syoriendtime</td><td>処理終了時刻</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syorinaiyoukbn</td><td>処理内容区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_DsSyoriNaiyouKbn C_DsSyoriNaiyouKbn}</td></tr>
 *  <tr><td>syorisyousai</td><td>処理詳細</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     MT_SousaRirekiSyousai
 * @see     GenMT_SousaRirekiSyousai
 * @see     QMT_SousaRirekiSyousai
 * @see     GenQMT_SousaRirekiSyousai
 */
public class PKMT_SousaRirekiSyousai extends AbstractExDBPrimaryKey<MT_SousaRirekiSyousai, PKMT_SousaRirekiSyousai> {

    private static final long serialVersionUID = 1L;

    public PKMT_SousaRirekiSyousai() {
    }

    public PKMT_SousaRirekiSyousai(String pTtdksikibetuid, Integer pSousarirekirenno) {
        ttdksikibetuid = pTtdksikibetuid;
        sousarirekirenno = pSousarirekirenno;
    }

    @Transient
    @Override
    public Class<MT_SousaRirekiSyousai> getEntityClass() {
        return MT_SousaRirekiSyousai.class;
    }

    private String ttdksikibetuid;

    public String getTtdksikibetuid() {
        return ttdksikibetuid;
    }

    public void setTtdksikibetuid(String pTtdksikibetuid) {
        ttdksikibetuid = pTtdksikibetuid;
    }
    private Integer sousarirekirenno;

    public Integer getSousarirekirenno() {
        return sousarirekirenno;
    }

    public void setSousarirekirenno(Integer pSousarirekirenno) {
        sousarirekirenno = pSousarirekirenno;
    }

}