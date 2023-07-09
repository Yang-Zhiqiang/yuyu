CREATE TABLE IT_KouzahuriMinyuTuuti_Z (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     tyouhyouymd                                        VARCHAR     (8)                                                       NOT NULL  ,  /* 帳票作成日 */
     syoruiCd                                           VARCHAR     (5)                                                                 ,  /* 書類コード */
     hassoukbn                                          VARCHAR     (1)                                                                 ,  /* 発送区分 */
     shskyno                                            VARCHAR     (7)                                                                 ,  /* 送付先郵便番号 */
     shsadr1kj                                          VARCHAR     (62)                                                                ,  /* 送付先住所１（漢字）（３０桁） */
     shsadr2kj                                          VARCHAR     (62)                                                                ,  /* 送付先住所２（漢字）（３０桁） */
     shsadr3kj                                          VARCHAR     (62)                                                                ,  /* 送付先住所３（漢字）（３０桁） */
     shsnmkj                                            VARCHAR     (32)                                                                ,  /* 送付先氏名（漢字） */
     toiawasesosikinmkj                                 VARCHAR     (32)                                                                ,  /* 問合せ先組織名（漢字） */
     toiawaseyno                                        VARCHAR     (8)                                                                 ,  /* 問合せ先郵便番号 */
     toiawaseadr1kj                                     VARCHAR     (32)                                                                ,  /* 問合せ先住所１（漢字） */
     toiawaseadr2kj                                     VARCHAR     (32)                                                                ,  /* 問合せ先住所２（漢字） */
     toiawaseadr3kj                                     VARCHAR     (32)                                                                ,  /* 問合せ先住所３（漢字） */
     toiawasetelno                                      VARCHAR     (14)                                                                ,  /* 問合せ先電話番号 */
     toiawaseteluktkkanou1                              VARCHAR     (38)                                                                ,  /* 問合せ先電話受付可能時間１ */
     toiawaseteluktkkanou2                              VARCHAR     (38)                                                                ,  /* 問合せ先電話受付可能時間２ */
     toiawasesosikinmkj2                                VARCHAR     (32)                                                                ,  /* 第２問合せ先組織名（漢字） */
     toiawasetelno2                                     VARCHAR     (14)                                                                ,  /* 第２問合せ先電話番号 */
     tuutinm30keta                                      VARCHAR     (62)                                                                ,  /* 通知名称（３０桁） */
     minyuttmsg1                                        VARCHAR     (76)                                                                ,  /* 未入通知メッセージ１ */
     minyuttmsg2                                        VARCHAR     (76)                                                                ,  /* 未入通知メッセージ２ */
     minyuttmsg3                                        VARCHAR     (76)                                                                ,  /* 未入通知メッセージ３ */
     minyuttmsg4                                        VARCHAR     (76)                                                                ,  /* 未入通知メッセージ４ */
     minyuttmsg5                                        VARCHAR     (76)                                                                ,  /* 未入通知メッセージ５ */
     minyuttmsg6                                        VARCHAR     (76)                                                                ,  /* 未入通知メッセージ６ */
     minyuttmsg7                                        VARCHAR     (76)                                                                ,  /* 未入通知メッセージ７ */
     minyuttmsg8                                        VARCHAR     (76)                                                                ,  /* 未入通知メッセージ８ */
     minyuttmsg9                                        VARCHAR     (76)                                                                ,  /* 未入通知メッセージ９ */
     minyuttmsg10                                       VARCHAR     (76)                                                                ,  /* 未入通知メッセージ１０ */
     minyuttmsg11                                       VARCHAR     (76)                                                                ,  /* 未入通知メッセージ１１ */
     minyuttmsg12                                       VARCHAR     (76)                                                                ,  /* 未入通知メッセージ１２ */
     pannainm                                           VARCHAR     (42)                                                                ,  /* 保険料案内名称 */
     hrkhou12keta                                       VARCHAR     (26)                                                                ,  /* 払込方法（１２桁） */
     hhknnmkj                                           VARCHAR     (32)                                                                ,  /* 被保険者名（漢字） */
     nexthurikaenaiyou1                                 VARCHAR     (76)                                                                ,  /* 次回振替内容１ */
     nexthurikaenaiyou2                                 VARCHAR     (76)                                                                ,  /* 次回振替内容２ */
     nexthurikaenaiyou3                                 VARCHAR     (76)                                                                ,  /* 次回振替内容３ */
     saikokutukiyykkn1                                  VARCHAR     (76)                                                                ,  /* 催告月猶予期間１ */
     saikokutukiyykkn2                                  VARCHAR     (76)                                                                ,  /* 催告月猶予期間２ */
     hrkmirmsg1                                         VARCHAR     (76)                                                                ,  /* 振込依頼メッセージ１ */
     hrkmirmsg2                                         VARCHAR     (76)                                                                ,  /* 振込依頼メッセージ２ */
     hrkmirmsg3                                         VARCHAR     (76)                                                                ,  /* 振込依頼メッセージ３ */
     zenhurikaenaiyou1                                  VARCHAR     (76)                                                                ,  /* 前回振替内容１ */
     zenhurikaenaiyou2                                  VARCHAR     (76)                                                                ,  /* 前回振替内容２ */
     zenhurikaenaiyou3                                  VARCHAR     (76)                                                                ,  /* 前回振替内容３ */
     zenhurikaenaiyou4                                  VARCHAR     (76)                                                                ,  /* 前回振替内容４ */
     hurikaekz37keta1                                   VARCHAR     (76)                                                                ,  /* 振替口座（３７桁）１ */
     hurikaekz37keta2                                   VARCHAR     (76)                                                                ,  /* 振替口座（３７桁）２ */
     hurikaekz37keta3                                   VARCHAR     (76)                                                                ,  /* 振替口座（３７桁）３ */
     hurikaekz37keta4                                   VARCHAR     (76)                                                                ,  /* 振替口座（３７桁）４ */
     hurikaekz37keta5                                   VARCHAR     (76)                                                                ,  /* 振替口座（３７桁）５ */
     hurikaekz37keta6                                   VARCHAR     (76)                                                                ,  /* 振替口座（３７桁）６ */
     minyuttaddmsg1                                     VARCHAR     (76)                                                                ,  /* 未入通知追加メッセージ１ */
     minyuttaddmsg2                                     VARCHAR     (76)                                                                ,  /* 未入通知追加メッセージ２ */
     minyuttaddmsg3                                     VARCHAR     (76)                                                                ,  /* 未入通知追加メッセージ３ */
     minyuttaddmsg4                                     VARCHAR     (76)                                                                ,  /* 未入通知追加メッセージ４ */
     minyuttaddmsg5                                     VARCHAR     (76)                                                                ,  /* 未入通知追加メッセージ５ */
     minyuttaddmsg6                                     VARCHAR     (76)                                                                ,  /* 未入通知追加メッセージ６ */
     minyuttaddmsg7                                     VARCHAR     (76)                                                                ,  /* 未入通知追加メッセージ７ */
     minyuttaddmsg8                                     VARCHAR     (76)                                                                ,  /* 未入通知追加メッセージ８ */
     minyuttaddmsg9                                     VARCHAR     (76)                                                                ,  /* 未入通知追加メッセージ９ */
     minyuttaddmsg10                                    VARCHAR     (76)                                                                ,  /* 未入通知追加メッセージ１０ */
     minyuttaddmsg11                                    VARCHAR     (76)                                                                ,  /* 未入通知追加メッセージ１１ */
     minyuttaddmsg12                                    VARCHAR     (76)                                                                ,  /* 未入通知追加メッセージ１２ */
     minyuttaddmsg13                                    VARCHAR     (76)                                                                ,  /* 未入通知追加メッセージ１３ */
     minyuttaddmsg14                                    VARCHAR     (76)                                                                ,  /* 未入通知追加メッセージ１４ */
     minyuttaddmsg15                                    VARCHAR     (76)                                                                ,  /* 未入通知追加メッセージ１５ */
     minyuttaddmsg16                                    VARCHAR     (76)                                                                ,  /* 未入通知追加メッセージ１６ */
     minyuttaddmsg17                                    VARCHAR     (76)                                                                ,  /* 未入通知追加メッセージ１７ */
     minyuttaddmsg18                                    VARCHAR     (76)                                                                ,  /* 未入通知追加メッセージ１８ */
     minyuttaddmsg19                                    VARCHAR     (76)                                                                ,  /* 未入通知追加メッセージ１９ */
     minyuttaddmsg20                                    VARCHAR     (76)                                                                ,  /* 未入通知追加メッセージ２０ */
     minyuttaddmsg21                                    VARCHAR     (76)                                                                ,  /* 未入通知追加メッセージ２１ */
     tuutisyuruicd                                      VARCHAR     (8)                                                                 ,  /* 通知種類コード */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                             ,  /* バージョン */
     saikokutuutizumiflg                                VARCHAR     (1)                                                                 ,  /* 催告通知作成済フラグ */
     tyouhyoukigoukbn                                   VARCHAR     (3)                                                                 ,  /* 帳票記号区分 */
     hrkkeiro                                           VARCHAR     (2)                                                                 ,  /* 払込経路 */
     jkipjytym                                          VARCHAR     (6)                                                                    /* 次回Ｐ充当年月 */
)
;

ALTER TABLE IT_KouzahuriMinyuTuuti_Z ADD CONSTRAINT PK_KouzahuriMinyuTuuti PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                    , /* 証券番号 */
     tyouhyouymd                                                /* 帳票作成日 */
) ;

CREATE INDEX IX1_KouzahuriMinyuTuuti ON IT_KouzahuriMinyuTuuti_Z (
     syono                                                    , /* 証券番号 */
     tyouhyouymd                                                /* 帳票作成日 */
) ;
