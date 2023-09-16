package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.db.mapping.GenJT_Mouside;


/**
 * 申出テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenJT_Mouside} の JavaDoc を参照してください。<br />
 * @see     GenJT_Mouside<br />
 * @see     PKJT_Mouside<br />
 * @see     QJT_Mouside<br />
 * @see     GenQJT_Mouside<br />
 */
@Entity
public class JT_Mouside extends GenJT_Mouside {

    private static final long serialVersionUID = 1L;

    public JT_Mouside() {
    }

    public JT_Mouside(String pSkno,String pSyono) {
        super(pSkno,pSyono);
    }



    private JT_SkKihon jT_SkKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=JT_Mouside.SKNO  , referencedColumnName=JT_SkKihon.SKNO, insertable=false, updatable=false),
        @JoinColumn(name=JT_Mouside.SYONO  , referencedColumnName=JT_SkKihon.SYONO, insertable=false, updatable=false)
    })
    public JT_SkKihon getSkKihon() {
        return jT_SkKihon;
    }

    public void setSkKihon(JT_SkKihon pJT_SkKihon) {
        this.jT_SkKihon = pJT_SkKihon;
    }

}

