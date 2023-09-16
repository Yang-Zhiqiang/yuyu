package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.db.mapping.GenJT_SateiSyouninRireki;


/**
 * 査定承認履歴テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenJT_SateiSyouninRireki} の JavaDoc を参照してください。<br />
 * @see     GenJT_SateiSyouninRireki<br />
 * @see     PKJT_SateiSyouninRireki<br />
 * @see     QJT_SateiSyouninRireki<br />
 * @see     GenQJT_SateiSyouninRireki<br />
 */
@Entity
public class JT_SateiSyouninRireki extends GenJT_SateiSyouninRireki {

    private static final long serialVersionUID = 1L;

    public JT_SateiSyouninRireki() {
    }

    public JT_SateiSyouninRireki(String pSkno,String pSyono,String pSateisyouninskbtkey) {
        super(pSkno,pSyono,pSateisyouninskbtkey);
    }



    private JT_SkKihon jT_SkKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=JT_SateiSyouninRireki.SKNO  , referencedColumnName=JT_SkKihon.SKNO, insertable=false, updatable=false),
        @JoinColumn(name=JT_SateiSyouninRireki.SYONO  , referencedColumnName=JT_SkKihon.SYONO, insertable=false, updatable=false)
    })
    public JT_SkKihon getSkKihon() {
        return jT_SkKihon;
    }

    public void setSkKihon(JT_SkKihon pJT_SkKihon) {
        this.jT_SkKihon = pJT_SkKihon;
    }

}

