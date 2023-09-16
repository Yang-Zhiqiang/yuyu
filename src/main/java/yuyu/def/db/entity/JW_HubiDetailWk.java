package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.db.mapping.GenJW_HubiDetailWk;


/**
 * 支払不備詳細ワークテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenJW_HubiDetailWk} の JavaDoc を参照してください。<br />
 * @see     GenJW_HubiDetailWk<br />
 * @see     PKJW_HubiDetailWk<br />
 * @see     QJW_HubiDetailWk<br />
 * @see     GenQJW_HubiDetailWk<br />
 */
@Entity
public class JW_HubiDetailWk extends GenJW_HubiDetailWk {

    private static final long serialVersionUID = 1L;

    public JW_HubiDetailWk() {
    }

    public JW_HubiDetailWk(String pKouteikanriid,Integer pRenno3keta) {
        super(pKouteikanriid,pRenno3keta);
    }



    private JW_HubiWk jW_HubiWk ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=JW_HubiDetailWk.KOUTEIKANRIID  , referencedColumnName=JW_HubiWk.KOUTEIKANRIID, insertable=false, updatable=false)
    })
    public JW_HubiWk getHubiWk() {
        return jW_HubiWk;
    }

    public void setHubiWk(JW_HubiWk pJW_HubiWk) {
        this.jW_HubiWk = pJW_HubiWk;
    }

}

