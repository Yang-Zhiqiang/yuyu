package yuyu.def.db.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import yuyu.def.db.id.PKAM_Role;
import yuyu.def.db.mapping.GenAM_Role;
import yuyu.def.db.meta.GenQAM_Role;
import yuyu.def.db.meta.QAM_Role;
import yuyu.infr.auth.AuthRoleParam;

import com.google.common.collect.Lists;

/**
 * ロールマスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenAM_Role} の JavaDoc を参照してください。
 * @see     GenAM_Role
 * @see     PKAM_Role
 * @see     QAM_Role
 * @see     GenQAM_Role
 */
@Entity
public class AM_Role extends GenAM_Role implements AuthRoleParam {

    private static final long serialVersionUID = 1L;

    public AM_Role() {
    }

    public AM_Role(String pRoleCd) {
        super(pRoleCd);
    }

    private List<AT_KinouKengen> aT_KinouKengens = Lists.newLinkedList();

    @Override
    @OneToMany(
        cascade       = { CascadeType.DETACH, CascadeType.REFRESH },
        orphanRemoval = true
        )
    @JoinColumn(name=AT_KinouKengen.ROLECD, referencedColumnName=AM_Role.ROLECD, insertable=false, updatable=false)
    public List<AT_KinouKengen> getKinouKengens(){
        return aT_KinouKengens;
    }

    public void setKinouKengens(List<AT_KinouKengen> pKinouKengens){
        aT_KinouKengens = pKinouKengens;
    }

    //    @OneToMany(
    //            targetEntity = AT_UserRole.class,
    //            fetch = FetchType.LAZY,
    //            cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REMOVE},
    //            orphanRemoval = true,
    //            mappedBy = "aM_Role"
    //            )
    //    private List<AT_UserRole> aT_UserRoles;
    //
    //    @Override
    //    @Transient
    //    public List<AT_UserRole> getUserRoles() {
    //        return aT_UserRoles = readyChildEntityList(aT_UserRoles);
    //    }

    // ↑
    // 2014/03/10 T.Hoshino プロパティー「userRoles」は廃止
    //
    // マスターテーブル側からトランザクション系子テーブルリストを取得するような
    // リレーションシップは定義すべきでない。
    // 特に userRoles の場合、ユーザー数の多い巨大システムではパンクする恐れがある。
    //
    // 当メソッドの利用箇所を探してみたところ、「ロール登録」機能でロールを削除する際、
    // 「既にユーザーに割り当て済みロールで削除不可能かどうかの判定」だけにしか利用されていなかった。
    // 「そんなのリレーションシップでなく、DAO でやれ」とか
    // 「そもそも『使われてるかどうか』が判れば良いだけなんだから、List<AT_UserRole> なんて
    //   要らねーだろ。 COUNT だけで十分だ」と思ったんで、
    // 「ロール登録」の当該部分を修正し、当プロパティーは廃止した。
    //
    // 本当は「kinouKengens」も同様に「マスター側から子テーブルリスト取得」なのだが、
    // 「そのロールで使える機能(権限)の件数」なんぞ、高が知れている。よって、
    // こっちは実データ量の少なさから「廃止だけは勘弁してやろう」って感じで、存続。
    //
    // リレーションシップは「何でもかんでも貼りゃあ良い」ってものじゃないんで、
    // 以下を十分検討すること。
    //
    // ・予測データ量（子レコード件数）は大丈夫か？
    //
    // ・リレーションを張る ＝ 挿入・削除に制約がかかる（親レコードが無ければ子の insert はできない、
    //   子レコードが０件にならないと親は削除できない、等） ということになるが、本当に大丈夫か？
    //
    // ・上の制約に関して、通常業務処理ならば業務手順通りに挿入・削除が行われるので問題ないが、
    //   バッチや外部連動で「親子を逆順にした方が処理効率が良い」なんて可能性は無いか？
    //
    // ・リレーションシップやめて「DAOクラスを使う」という選択肢はダメなのか？
}
