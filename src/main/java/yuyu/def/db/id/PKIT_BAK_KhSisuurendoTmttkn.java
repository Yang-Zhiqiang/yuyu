package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.IT_BAK_KhSisuurendoTmttkn;
import yuyu.def.db.mapping.GenIT_BAK_KhSisuurendoTmttkn;
import yuyu.def.db.meta.GenQIT_BAK_KhSisuurendoTmttkn;
import yuyu.def.db.meta.QIT_BAK_KhSisuurendoTmttkn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 指数連動積増型年金積立金バックアップテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_BAK_KhSisuurendoTmttkn}</td><td colspan="3">指数連動積増型年金積立金バックアップテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTrkssikibetukey trkssikibetukey}</td><td>取消識別キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTmttkntaisyouym tmttkntaisyouym}</td><td>積立金対象年月</td><td align="center">○</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRenno renno}</td><td>連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>tmttknkouryokukaisiymd</td><td>積立金効力開始日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>teiritutmttkngk</td><td>定率積立金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>sisuurendoutmttkngk</td><td>指数連動積立金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>sisuuupritu</td><td>指数上昇率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>tmttknzoukaritu</td><td>積立金増加率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>tmttknhaneitmmshanteiymd</td><td>積立金反映時積増判定日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>tmttknhaneisisuu</td><td>積立金反映時指数</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>itenmaeteiritutmttkngk</td><td>移転前定率積立金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>itenmaesisuurendoutmttkngk</td><td>移転前指数連動積立金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 * </table>
 * @see     IT_BAK_KhSisuurendoTmttkn
 * @see     GenIT_BAK_KhSisuurendoTmttkn
 * @see     QIT_BAK_KhSisuurendoTmttkn
 * @see     GenQIT_BAK_KhSisuurendoTmttkn
 */
public class PKIT_BAK_KhSisuurendoTmttkn extends AbstractExDBPrimaryKey<IT_BAK_KhSisuurendoTmttkn, PKIT_BAK_KhSisuurendoTmttkn> {

    private static final long serialVersionUID = 1L;

    public PKIT_BAK_KhSisuurendoTmttkn() {
    }

    public PKIT_BAK_KhSisuurendoTmttkn(
        String pKbnkey,
        String pSyono,
        String pTrkssikibetukey,
        BizDateYM pTmttkntaisyouym,
        Integer pRenno
    ) {
        kbnkey = pKbnkey;
        syono = pSyono;
        trkssikibetukey = pTrkssikibetukey;
        tmttkntaisyouym = pTmttkntaisyouym;
        renno = pRenno;
    }

    @Transient
    @Override
    public Class<IT_BAK_KhSisuurendoTmttkn> getEntityClass() {
        return IT_BAK_KhSisuurendoTmttkn.class;
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
    private String trkssikibetukey;

    public String getTrkssikibetukey() {
        return trkssikibetukey;
    }

    public void setTrkssikibetukey(String pTrkssikibetukey) {
        trkssikibetukey = pTrkssikibetukey;
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