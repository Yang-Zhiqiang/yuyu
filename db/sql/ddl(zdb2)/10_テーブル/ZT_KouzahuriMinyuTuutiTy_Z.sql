CREATE TABLE ZT_KouzahuriMinyuTuutiTy_Z (
     ztysyoruicd                                        VARCHAR     (5)                                                                 ,  /* （中継用）書類コード */
     ztyhassoukbn                                       VARCHAR     (1)                                                                 ,  /* （中継用）発送区分 */
     ztytyouhyouymd                                     VARCHAR     (8)                                                       NOT NULL  ,  /* （中継用）帳票作成日 */
     ztytyouhyouymdkj                                   VARCHAR     (24)                                                                ,  /* （中継用）帳票作成日（漢字） */
     ztysyono                                           VARCHAR     (11)                                                      NOT NULL  ,  /* （中継用）証券番号 */
     ztyyobiv9                                          VARCHAR     (9)                                                                 ,  /* （中継用）予備項目Ｖ９ */
     ztyansyuyouyobin10                                 VARCHAR     (10)                                                                ,  /* （中継用）案内収納用予備項目Ｎ１０ */
     ztyshskyno                                         VARCHAR     (7)                                                                 ,  /* （中継用）送付先郵便番号 */
     ztyshskadr1kj                                      VARCHAR     (62)                                                                ,  /* （中継用）送付先住所１（漢字） */
     ztyshskadr2kj                                      VARCHAR     (62)                                                                ,  /* （中継用）送付先住所２（漢字） */
     ztyshskadr3kj                                      VARCHAR     (62)                                                                ,  /* （中継用）送付先住所３（漢字） */
     ztyshsnmkj                                         VARCHAR     (32)                                                                ,  /* （中継用）送付先名（漢字） */
     ztyyobiv43                                         VARCHAR     (43)                                                                ,  /* （中継用）予備項目Ｖ４３ */
     ztyansyuyouyobin10x2                               VARCHAR     (10)                                                                ,  /* （中継用）案内収納用予備項目Ｎ１０＿２ */
     ztytawsosikikj                                     VARCHAR     (32)                                                                ,  /* （中継用）問合せ先組織名（漢字） */
     ztytawyno                                          VARCHAR     (8)                                                                 ,  /* （中継用）問合せ先郵便番号 */
     ztytawadr1kj                                       VARCHAR     (32)                                                                ,  /* （中継用）問合せ先住所１（漢字） */
     ztytawadr2kj                                       VARCHAR     (32)                                                                ,  /* （中継用）問合せ先住所２（漢字） */
     ztytawadr3kj                                       VARCHAR     (32)                                                                ,  /* （中継用）問合せ先住所３（漢字） */
     ztytawtelnov14                                     VARCHAR     (14)                                                                ,  /* （中継用）問合せ先電話番号Ｖ１４ */
     ztytawteluktkkanou1                                VARCHAR     (52)                                                                ,  /* （中継用）問合せ先電話受付可能時間１ */
     ztytawteluktkkanou2                                VARCHAR     (52)                                                                ,  /* （中継用）問合せ先電話受付可能時間２ */
     ztydai2tawsosikinmkj                               VARCHAR     (32)                                                                ,  /* （中継用）第２問合せ先組織名（漢字） */
     ztydai2tawtelno                                    VARCHAR     (14)                                                                ,  /* （中継用）第２問合せ先電話番号 */
     ztysclatosyono                                     VARCHAR     (11)                                                                ,  /* （中継用）スクランブル後証券番号 */
     ztysakunm15keta                                    VARCHAR     (15)                                                                ,  /* （中継用）作成番号（１５桁） */
     ztyyobiv61                                         VARCHAR     (61)                                                                ,  /* （中継用）予備項目Ｖ６１ */
     ztyansyuyouyobin10x3                               VARCHAR     (10)                                                                ,  /* （中継用）案内収納用予備項目Ｎ１０＿３ */
     ztytuutinm30keta                                   VARCHAR     (62)                                                                ,  /* （中継用）通知名称（３０桁） */
     ztyminyuttmsg1                                     VARCHAR     (76)                                                                ,  /* （中継用）未入通知メッセージ１ */
     ztyminyuttmsg2                                     VARCHAR     (76)                                                                ,  /* （中継用）未入通知メッセージ２ */
     ztyminyuttmsg3                                     VARCHAR     (76)                                                                ,  /* （中継用）未入通知メッセージ３ */
     ztyminyuttmsg4                                     VARCHAR     (76)                                                                ,  /* （中継用）未入通知メッセージ４ */
     ztyminyuttmsg5                                     VARCHAR     (76)                                                                ,  /* （中継用）未入通知メッセージ５ */
     ztyminyuttmsg6                                     VARCHAR     (76)                                                                ,  /* （中継用）未入通知メッセージ６ */
     ztyminyuttmsg7                                     VARCHAR     (76)                                                                ,  /* （中継用）未入通知メッセージ７ */
     ztyminyuttmsg8                                     VARCHAR     (76)                                                                ,  /* （中継用）未入通知メッセージ８ */
     ztyminyuttmsg9                                     VARCHAR     (76)                                                                ,  /* （中継用）未入通知メッセージ９ */
     ztyminyuttmsg10                                    VARCHAR     (76)                                                                ,  /* （中継用）未入通知メッセージ１０ */
     ztyminyuttmsg11                                    VARCHAR     (76)                                                                ,  /* （中継用）未入通知メッセージ１１ */
     ztyminyuttmsg12                                    VARCHAR     (76)                                                                ,  /* （中継用）未入通知メッセージ１２ */
     ztyyobiv174                                        VARCHAR     (174)                                                               ,  /* （中継用）予備項目Ｖ１７４ */
     ztyansyuyouyobin10x4                               VARCHAR     (10)                                                                ,  /* （中継用）案内収納用予備項目Ｎ１０＿４ */
     ztypannainm                                        VARCHAR     (42)                                                                ,  /* （中継用）保険料案内名称 */
     ztyhrkhou12keta                                    VARCHAR     (26)                                                                ,  /* （中継用）払込方法（１２桁） */
     ztysyono2                                          VARCHAR     (11)                                                                ,  /* （中継用）証券番号２ */
     ztyhhknnmkj                                        VARCHAR     (32)                                                                ,  /* （中継用）被保険者名（漢字） */
     ztynextkzhrnaiyou1                                 VARCHAR     (76)                                                                ,  /* （中継用）次回振替内容１ */
     ztynextkzhrnaiyou2                                 VARCHAR     (76)                                                                ,  /* （中継用）次回振替内容２ */
     ztynextkzhrnaiyou3                                 VARCHAR     (76)                                                                ,  /* （中継用）次回振替内容３ */
     ztysaikokuyykk1                                    VARCHAR     (76)                                                                ,  /* （中継用）催告月猶予期間１ */
     ztysaikokuyykk2                                    VARCHAR     (76)                                                                ,  /* （中継用）催告月猶予期間２ */
     ztyhrkmiraimsg1                                    VARCHAR     (76)                                                                ,  /* （中継用）振込依頼メッセージ１ */
     ztyhrkmiraimsg2                                    VARCHAR     (76)                                                                ,  /* （中継用）振込依頼メッセージ２ */
     ztyhrkmiraimsg3                                    VARCHAR     (76)                                                                ,  /* （中継用）振込依頼メッセージ３ */
     ztyzenhurinaiyou1                                  VARCHAR     (76)                                                                ,  /* （中継用）前回振替内容１ */
     ztyzenhurinaiyou2                                  VARCHAR     (76)                                                                ,  /* （中継用）前回振替内容２ */
     ztyzenhurinaiyou3                                  VARCHAR     (76)                                                                ,  /* （中継用）前回振替内容３ */
     ztyzenhurinaiyou4                                  VARCHAR     (76)                                                                ,  /* （中継用）前回振替内容４ */
     ztyyobiv196                                        VARCHAR     (196)                                                               ,  /* （中継用）予備項目Ｖ１９６ */
     ztyansyuyouyobin10x5                               VARCHAR     (10)                                                                ,  /* （中継用）案内収納用予備項目Ｎ１０＿５ */
     ztyhurikaekz37keta1                                VARCHAR     (76)                                                                ,  /* （中継用）振替口座（３７桁）１ */
     ztyhurikaekz37keta2                                VARCHAR     (76)                                                                ,  /* （中継用）振替口座（３７桁）２ */
     ztyhurikaekz37keta3                                VARCHAR     (76)                                                                ,  /* （中継用）振替口座（３７桁）３ */
     ztyhurikaekz37keta4                                VARCHAR     (76)                                                                ,  /* （中継用）振替口座（３７桁）４ */
     ztyhurikaekz37keta5                                VARCHAR     (76)                                                                ,  /* （中継用）振替口座（３７桁）５ */
     ztyhurikaekz37keta6                                VARCHAR     (76)                                                                ,  /* （中継用）振替口座（３７桁）６ */
     ztyyobiv88                                         VARCHAR     (88)                                                                ,  /* （中継用）予備項目Ｖ８８ */
     ztyansyuyouyobin10x6                               VARCHAR     (10)                                                                ,  /* （中継用）案内収納用予備項目Ｎ１０＿６ */
     ztyminyuttaddmsg1                                  VARCHAR     (76)                                                                ,  /* （中継用）未入通知追加メッセージ１ */
     ztyminyuttaddmsg2                                  VARCHAR     (76)                                                                ,  /* （中継用）未入通知追加メッセージ２ */
     ztyminyuttaddmsg3                                  VARCHAR     (76)                                                                ,  /* （中継用）未入通知追加メッセージ３ */
     ztyminyuttaddmsg4                                  VARCHAR     (76)                                                                ,  /* （中継用）未入通知追加メッセージ４ */
     ztyminyuttaddmsg5                                  VARCHAR     (76)                                                                ,  /* （中継用）未入通知追加メッセージ５ */
     ztyminyuttaddmsg6                                  VARCHAR     (76)                                                                ,  /* （中継用）未入通知追加メッセージ６ */
     ztyminyuttaddmsg7                                  VARCHAR     (76)                                                                ,  /* （中継用）未入通知追加メッセージ７ */
     ztyminyuttaddmsg8                                  VARCHAR     (76)                                                                ,  /* （中継用）未入通知追加メッセージ８ */
     ztyminyuttaddmsg9                                  VARCHAR     (76)                                                                ,  /* （中継用）未入通知追加メッセージ９ */
     ztyminyuttaddmsg10                                 VARCHAR     (76)                                                                ,  /* （中継用）未入通知追加メッセージ１０ */
     ztyminyuttaddmsg11                                 VARCHAR     (76)                                                                ,  /* （中継用）未入通知追加メッセージ１１ */
     ztyminyuttaddmsg12                                 VARCHAR     (76)                                                                ,  /* （中継用）未入通知追加メッセージ１２ */
     ztyminyuttaddmsg13                                 VARCHAR     (76)                                                                ,  /* （中継用）未入通知追加メッセージ１３ */
     ztyminyuttaddmsg14                                 VARCHAR     (76)                                                                ,  /* （中継用）未入通知追加メッセージ１４ */
     ztyminyuttaddmsg15                                 VARCHAR     (76)                                                                ,  /* （中継用）未入通知追加メッセージ１５ */
     ztyminyuttaddmsg16                                 VARCHAR     (76)                                                                ,  /* （中継用）未入通知追加メッセージ１６ */
     ztyminyuttaddmsg17                                 VARCHAR     (76)                                                                ,  /* （中継用）未入通知追加メッセージ１７ */
     ztyminyuttaddmsg18                                 VARCHAR     (76)                                                                ,  /* （中継用）未入通知追加メッセージ１８ */
     ztyminyuttaddmsg19                                 VARCHAR     (76)                                                                ,  /* （中継用）未入通知追加メッセージ１９ */
     ztyminyuttaddmsg20                                 VARCHAR     (76)                                                                ,  /* （中継用）未入通知追加メッセージ２０ */
     ztyminyuttaddmsg21                                 VARCHAR     (76)                                                                ,  /* （中継用）未入通知追加メッセージ２１ */
     ztyyobiv250                                        VARCHAR     (250)                                                               ,  /* （中継用）予備項目Ｖ２５０ */
     ztyyobiv60                                         VARCHAR     (60)                                                                ,  /* （中継用）予備項目Ｖ６０ */
     ztyansyuyouyobin10x7                               VARCHAR     (10)                                                                ,  /* （中継用）案内収納用予備項目Ｎ１０＿７ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE ZT_KouzahuriMinyuTuutiTy_Z ADD CONSTRAINT PK_KouzahuriMinyuTuutiTy PRIMARY KEY (
     ztytyouhyouymd                                           , /* （中継用）帳票作成日 */
     ztysyono                                                   /* （中継用）証券番号 */
) ;
