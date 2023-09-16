package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.IT_HokenryouTmttkn;
import yuyu.def.db.mapping.GenIT_HokenryouTmttkn;
import yuyu.def.db.meta.GenQIT_HokenryouTmttkn;
import yuyu.def.db.meta.QIT_HokenryouTmttkn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 保険料積立金テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_HokenryouTmttkn}</td><td colspan="3">保険料積立金テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTmttkntaisyouym tmttkntaisyouym}</td><td>積立金対象年月</td><td align="center">○</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRenno renno}</td><td>連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ptmttkngk</td><td>保険料積立金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kihrkmpstgk</td><td>既払込保険料相当額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>tyouseimaeptmttkngk</td><td>調整前保険料積立金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_HokenryouTmttkn
 * @see     GenIT_HokenryouTmttkn
 * @see     QIT_HokenryouTmttkn
 * @see     GenQIT_HokenryouTmttkn
 */
public class PKIT_HokenryouTmttkn extends AbstractExDBPrimaryKey<IT_HokenryouTmttkn, PKIT_HokenryouTmttkn> {

    private static final long serialVersionUID = 1L;

    public PKIT_HokenryouTmttkn() {
    }

    public PKIT_HokenryouTmttkn(
        String pKbnkey,
        String pSyono,
        BizDateYM pTmttkntaisyouym,
        Integer pRenno
    ) {
        kbnkey = pKbnkey;
        syono = pSyono;
        tmttkntaisyouym = pTmttkntaisyouym;
        renno = pRenno;
    }

    @Transient
    @Override
    public Class<IT_HokenryouTmttkn> getEntityClass() {
        return IT_HokenryouTmttkn.class;
    }

    private String kbnkey;

    public String getKbnkey() {
        return kbnkey;
    }

    public void setKbnkey(String pKbnkey) {
        kbnkey = pKbnkey;
    }
    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }
    private BizDateYM tmttkntaisyouym;

    @org.hibernate.annotations.Type(type="BizDateYMType")
    public BizDateYM getTmttkntaisyouym() {
        return tmttkntaisyouym;
    }

    public void setTmttkntaisyouym(BizDateYM pTmttkntaisyouym) {
        tmttkntaisyouym = pTmttkntaisyouym;
    }
    private Integer renno;

    public Integer getRenno() {
        return renno;
    }

    public void setRenno(Integer pRenno) {
        renno = pRenno;
    }

}