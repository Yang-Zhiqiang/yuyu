CREATE TABLE ZT_KouzahuriMinyuTuutiRn (
     zrnsyoruicd                                        CHAR        (5)                                                       NOT NULL  ,  /* （連携用）書類コード */
     zrnhassoukbn                                       CHAR        (1)                                                       NOT NULL  ,  /* （連携用）発送区分 */
     zrntyouhyouymd                                     CHAR        (8)                                                       NOT NULL  ,  /* （連携用）帳票作成日 */
     zrntyouhyouymdkj                                   VARCHAR     (11)                                                      NOT NULL  ,  /* （連携用）帳票作成日（漢字） */
     zrnsyono                                           CHAR        (11)                                                      NOT NULL  ,  /* （連携用）証券番号 */
     zrnyobiv9                                          CHAR        (9)                                                       NOT NULL  ,  /* （連携用）予備項目Ｖ９ */
     zrnansyuyouyobin10                                 CHAR        (10)                                                      NOT NULL  ,  /* （連携用）案内収納用予備項目Ｎ１０ */
     zrnshskyno                                         CHAR        (7)                                                       NOT NULL  ,  /* （連携用）送付先郵便番号 */
     zrnshskadr1kj                                      VARCHAR     (30)                                                      NOT NULL  ,  /* （連携用）送付先住所１（漢字） */
     zrnshskadr2kj                                      VARCHAR     (30)                                                      NOT NULL  ,  /* （連携用）送付先住所２（漢字） */
     zrnshskadr3kj                                      VARCHAR     (30)                                                      NOT NULL  ,  /* （連携用）送付先住所３（漢字） */
     zrnshsnmkj                                         VARCHAR     (15)                                                      NOT NULL  ,  /* （連携用）送付先名（漢字） */
     zrnyobiv43                                         CHAR        (43)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ４３ */
     zrnansyuyouyobin10x2                               CHAR        (10)                                                      NOT NULL  ,  /* （連携用）案内収納用予備項目Ｎ１０＿２ */
     zrntawsosikikj                                     VARCHAR     (15)                                                      NOT NULL  ,  /* （連携用）問合せ先組織名（漢字） */
     zrntawyno                                          CHAR        (8)                                                       NOT NULL  ,  /* （連携用）問合せ先郵便番号 */
     zrntawadr1kj                                       VARCHAR     (15)                                                      NOT NULL  ,  /* （連携用）問合せ先住所１（漢字） */
     zrntawadr2kj                                       VARCHAR     (15)                                                      NOT NULL  ,  /* （連携用）問合せ先住所２（漢字） */
     zrntawadr3kj                                       VARCHAR     (15)                                                      NOT NULL  ,  /* （連携用）問合せ先住所３（漢字） */
     zrntawtelnov14                                     CHAR        (14)                                                      NOT NULL  ,  /* （連携用）問合せ先電話番号Ｖ１４ */
     zrntawteluktkkanou1                                VARCHAR     (25)                                                      NOT NULL  ,  /* （連携用）問合せ先電話受付可能時間１ */
     zrntawteluktkkanou2                                VARCHAR     (25)                                                      NOT NULL  ,  /* （連携用）問合せ先電話受付可能時間２ */
     zrndai2tawsosikinmkj                               VARCHAR     (15)                                                      NOT NULL  ,  /* （連携用）第２問合せ先組織名（漢字） */
     zrndai2tawtelno                                    CHAR        (14)                                                      NOT NULL  ,  /* （連携用）第２問合せ先電話番号 */
     zrnsclatosyono                                     CHAR        (11)                                                      NOT NULL  ,  /* （連携用）スクランブル後証券番号 */
     zrnsakunm15keta                                    CHAR        (15)                                                      NOT NULL  ,  /* （連携用）作成番号（１５桁） */
     zrnyobiv61                                         CHAR        (61)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ６１ */
     zrnansyuyouyobin10x3                               CHAR        (10)                                                      NOT NULL  ,  /* （連携用）案内収納用予備項目Ｎ１０＿３ */
     zrntuutinm30keta                                   VARCHAR     (30)                                                      NOT NULL  ,  /* （連携用）通知名称（３０桁） */
     zrnminyuttmsg1                                     VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）未入通知メッセージ１ */
     zrnminyuttmsg2                                     VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）未入通知メッセージ２ */
     zrnminyuttmsg3                                     VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）未入通知メッセージ３ */
     zrnminyuttmsg4                                     VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）未入通知メッセージ４ */
     zrnminyuttmsg5                                     VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）未入通知メッセージ５ */
     zrnminyuttmsg6                                     VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）未入通知メッセージ６ */
     zrnminyuttmsg7                                     VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）未入通知メッセージ７ */
     zrnminyuttmsg8                                     VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）未入通知メッセージ８ */
     zrnminyuttmsg9                                     VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）未入通知メッセージ９ */
     zrnminyuttmsg10                                    VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）未入通知メッセージ１０ */
     zrnminyuttmsg11                                    VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）未入通知メッセージ１１ */
     zrnminyuttmsg12                                    VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）未入通知メッセージ１２ */
     zrnyobiv174                                        CHAR        (174)                                                     NOT NULL  ,  /* （連携用）予備項目Ｖ１７４ */
     zrnansyuyouyobin10x4                               CHAR        (10)                                                      NOT NULL  ,  /* （連携用）案内収納用予備項目Ｎ１０＿４ */
     zrnpannainm                                        VARCHAR     (20)                                                      NOT NULL  ,  /* （連携用）保険料案内名称 */
     zrnhrkhou12keta                                    VARCHAR     (12)                                                      NOT NULL  ,  /* （連携用）払込方法（１２桁） */
     zrnsyono2                                          CHAR        (11)                                                      NOT NULL  ,  /* （連携用）証券番号２ */
     zrnhhknnmkj                                        VARCHAR     (15)                                                      NOT NULL  ,  /* （連携用）被保険者名（漢字） */
     zrnnextkzhrnaiyou1                                 VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）次回振替内容１ */
     zrnnextkzhrnaiyou2                                 VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）次回振替内容２ */
     zrnnextkzhrnaiyou3                                 VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）次回振替内容３ */
     zrnsaikokuyykk1                                    VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）催告月猶予期間１ */
     zrnsaikokuyykk2                                    VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）催告月猶予期間２ */
     zrnhrkmiraimsg1                                    VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）振込依頼メッセージ１ */
     zrnhrkmiraimsg2                                    VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）振込依頼メッセージ２ */
     zrnhrkmiraimsg3                                    VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）振込依頼メッセージ３ */
     zrnzenhurinaiyou1                                  VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）前回振替内容１ */
     zrnzenhurinaiyou2                                  VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）前回振替内容２ */
     zrnzenhurinaiyou3                                  VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）前回振替内容３ */
     zrnzenhurinaiyou4                                  VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）前回振替内容４ */
     zrnyobiv196                                        CHAR        (196)                                                     NOT NULL  ,  /* （連携用）予備項目Ｖ１９６ */
     zrnansyuyouyobin10x5                               CHAR        (10)                                                      NOT NULL  ,  /* （連携用）案内収納用予備項目Ｎ１０＿５ */
     zrnhurikaekz37keta1                                VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）振替口座（３７桁）１ */
     zrnhurikaekz37keta2                                VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）振替口座（３７桁）２ */
     zrnhurikaekz37keta3                                VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）振替口座（３７桁）３ */
     zrnhurikaekz37keta4                                VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）振替口座（３７桁）４ */
     zrnhurikaekz37keta5                                VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）振替口座（３７桁）５ */
     zrnhurikaekz37keta6                                VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）振替口座（３７桁）６ */
     zrnyobiv88                                         CHAR        (88)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ８８ */
     zrnansyuyouyobin10x6                               CHAR        (10)                                                      NOT NULL  ,  /* （連携用）案内収納用予備項目Ｎ１０＿６ */
     zrnminyuttaddmsg1                                  VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）未入通知追加メッセージ１ */
     zrnminyuttaddmsg2                                  VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）未入通知追加メッセージ２ */
     zrnminyuttaddmsg3                                  VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）未入通知追加メッセージ３ */
     zrnminyuttaddmsg4                                  VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）未入通知追加メッセージ４ */
     zrnminyuttaddmsg5                                  VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）未入通知追加メッセージ５ */
     zrnminyuttaddmsg6                                  VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）未入通知追加メッセージ６ */
     zrnminyuttaddmsg7                                  VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）未入通知追加メッセージ７ */
     zrnminyuttaddmsg8                                  VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）未入通知追加メッセージ８ */
     zrnminyuttaddmsg9                                  VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）未入通知追加メッセージ９ */
     zrnminyuttaddmsg10                                 VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）未入通知追加メッセージ１０ */
     zrnminyuttaddmsg11                                 VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）未入通知追加メッセージ１１ */
     zrnminyuttaddmsg12                                 VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）未入通知追加メッセージ１２ */
     zrnminyuttaddmsg13                                 VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）未入通知追加メッセージ１３ */
     zrnminyuttaddmsg14                                 VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）未入通知追加メッセージ１４ */
     zrnminyuttaddmsg15                                 VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）未入通知追加メッセージ１５ */
     zrnminyuttaddmsg16                                 VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）未入通知追加メッセージ１６ */
     zrnminyuttaddmsg17                                 VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）未入通知追加メッセージ１７ */
     zrnminyuttaddmsg18                                 VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）未入通知追加メッセージ１８ */
     zrnminyuttaddmsg19                                 VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）未入通知追加メッセージ１９ */
     zrnminyuttaddmsg20                                 VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）未入通知追加メッセージ２０ */
     zrnminyuttaddmsg21                                 VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）未入通知追加メッセージ２１ */
     zrnyobiv250                                        CHAR        (250)                                                     NOT NULL  ,  /* （連携用）予備項目Ｖ２５０ */
     zrnyobiv60                                         CHAR        (60)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ６０ */
     zrnansyuyouyobin10x7                               CHAR        (10)                                                      NOT NULL     /* （連携用）案内収納用予備項目Ｎ１０＿７ */
)
;

ALTER TABLE ZT_KouzahuriMinyuTuutiRn ADD CONSTRAINT PK_KouzahuriMinyuTuutiRn PRIMARY KEY (
     zrntyouhyouymd                                           , /* （連携用）帳票作成日 */
     zrnsyono                                                   /* （連携用）証券番号 */
) ;
