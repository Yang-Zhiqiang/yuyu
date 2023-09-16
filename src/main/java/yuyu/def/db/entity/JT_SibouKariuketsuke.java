package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.db.mapping.GenJT_SibouKariuketsuke;


/**
 * 死亡仮受付テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenJT_SibouKariuketsuke} の JavaDoc を参照してください。<br />
 * @see     GenJT_SibouKariuketsuke<br />
 * @see     PKJT_SibouKariuketsuke<br />
 * @see     QJT_SibouKariuketsuke<br />
 * @see     GenQJT_SibouKariuketsuke<br />
 */
@Entity
public class JT_SibouKariuketsuke extends GenJT_SibouKariuketsuke {

    private static final long serialVersionUID = 1L;

    public JT_SibouKariuketsuke() {
    }

    public JT_SibouKariuketsuke(String pSkno,String pSyono) {
        super(pSkno,pSyono);
    }



    private JT_SkKihon jT_SkKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=JT_SibouKariuketsuke.SKNO  , referencedColumnName=JT_SkKihon.SKNO, insertable=false, updatable=false),
        @JoinColumn(name=JT_SibouKariuketsuke.SYONO  , referencedColumnName=JT_SkKihon.SYONO, insertable=false, updatable=false)
    })
    public JT_SkKihon getSkKihon() {
        return jT_SkKihon;
    }

    public void setSkKihon(JT_SkKihon pJT_SkKihon) {
        this.jT_SkKihon = pJT_SkKihon;
    }

}

