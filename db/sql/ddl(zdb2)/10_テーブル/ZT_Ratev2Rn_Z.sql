CREATE TABLE ZT_Ratev2Rn_Z (
     zrnhknsyukigou                                     CHAR        (2)                                                       NOT NULL  ,  /* （連携用）保険種類記号 */
     zrnhknsyuruikigousedaikbn                          CHAR        (1)                                                       NOT NULL  ,  /* （連携用）保険種類記号世代区分 */
     zrnyoteiriritu                                     CHAR        (3)                                                       NOT NULL  ,  /* （連携用）予定利率 */
     zrnpmenkbn                                         CHAR        (1)                                                       NOT NULL  ,  /* （連携用）Ｐ免区分 */
     zrnhrkkaisuukbn                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込回数区分 */
     zrnhhknsei                                         CHAR        (1)                                                       NOT NULL  ,  /* （連携用）被保険者性別 */
     zrnkeiyakujihhknnen                                CHAR        (3)                                                       NOT NULL  ,  /* （連携用）契約時被保険者年令 */
     zrnsaimnkkykhyj                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）才満期契約表示 */
     zrnhknkkn                                          CHAR        (2)                                                       NOT NULL  ,  /* （連携用）保険期間 */
     zrnphrkkikn                                        CHAR        (2)                                                       NOT NULL  ,  /* （連携用）Ｐ払込期間 */
     zrnannaifuyouriyuukbn                              CHAR        (2)                                                       NOT NULL  ,  /* （連携用）案内不要理由区分 */
     zrntuukasyukbn                                     CHAR        (1)                                                       NOT NULL  ,  /* （連携用）通貨種類区分 */
     zrndai1hknkkn                                      CHAR        (2)                                                       NOT NULL  ,  /* （連携用）第１保険期間 */
     zrnvrate00                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート００ */
     zrnvrate01                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート０１ */
     zrnvrate02                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート０２ */
     zrnvrate03                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート０３ */
     zrnvrate04                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート０４ */
     zrnvrate05                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート０５ */
     zrnvrate06                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート０６ */
     zrnvrate07                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート０７ */
     zrnvrate08                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート０８ */
     zrnvrate09                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート０９ */
     zrnvrate10                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート１０ */
     zrnvrate11                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート１１ */
     zrnvrate12                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート１２ */
     zrnvrate13                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート１３ */
     zrnvrate14                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート１４ */
     zrnvrate15                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート１５ */
     zrnvrate16                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート１６ */
     zrnvrate17                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート１７ */
     zrnvrate18                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート１８ */
     zrnvrate19                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート１９ */
     zrnvrate20                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート２０ */
     zrnvrate21                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート２１ */
     zrnvrate22                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート２２ */
     zrnvrate23                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート２３ */
     zrnvrate24                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート２４ */
     zrnvrate25                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート２５ */
     zrnvrate26                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート２６ */
     zrnvrate27                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート２７ */
     zrnvrate28                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート２８ */
     zrnvrate29                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート２９ */
     zrnvrate30                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート３０ */
     zrnvrate31                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート３１ */
     zrnvrate32                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート３２ */
     zrnvrate33                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート３３ */
     zrnvrate34                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート３４ */
     zrnvrate35                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート３５ */
     zrnvrate36                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート３６ */
     zrnvrate37                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート３７ */
     zrnvrate38                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート３８ */
     zrnvrate39                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート３９ */
     zrnvrate40                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート４０ */
     zrnvrate41                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート４１ */
     zrnvrate42                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート４２ */
     zrnvrate43                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート４３ */
     zrnvrate44                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート４４ */
     zrnvrate45                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート４５ */
     zrnvrate46                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート４６ */
     zrnvrate47                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート４７ */
     zrnvrate48                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート４８ */
     zrnvrate49                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート４９ */
     zrnvrate50                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート５０ */
     zrnvrate51                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート５１ */
     zrnvrate52                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート５２ */
     zrnvrate53                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート５３ */
     zrnvrate54                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート５４ */
     zrnvrate55                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート５５ */
     zrnvrate56                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート５６ */
     zrnvrate57                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート５７ */
     zrnvrate58                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート５８ */
     zrnvrate59                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート５９ */
     zrnvrate60                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート６０ */
     zrnvrate61                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート６１ */
     zrnvrate62                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート６２ */
     zrnvrate63                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート６３ */
     zrnvrate64                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート６４ */
     zrnvrate65                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート６５ */
     zrnvrate66                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート６６ */
     zrnvrate67                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート６７ */
     zrnvrate68                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート６８ */
     zrnvrate69                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート６９ */
     zrnvrate70                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート７０ */
     zrnvrate71                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート７１ */
     zrnvrate72                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート７２ */
     zrnvrate73                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート７３ */
     zrnvrate74                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート７４ */
     zrnvrate75                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート７５ */
     zrnvrate76                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート７６ */
     zrnvrate77                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート７７ */
     zrnvrate78                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート７８ */
     zrnvrate79                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート７９ */
     zrnvrate80                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート８０ */
     zrnvrate81                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート８１ */
     zrnvrate82                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート８２ */
     zrnvrate83                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート８３ */
     zrnvrate84                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート８４ */
     zrnvrate85                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート８５ */
     zrnvrate86                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート８６ */
     zrnvrate87                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート８７ */
     zrnvrate88                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート８８ */
     zrnvrate89                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート８９ */
     zrnvrate90                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート９０ */
     zrnvrate91                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート９１ */
     zrnvrate92                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート９２ */
     zrnvrate93                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート９３ */
     zrnvrate94                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート９４ */
     zrnvrate95                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート９５ */
     zrnvrate96                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート９６ */
     zrnvrate97                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート９７ */
     zrnvrate98                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート９８ */
     zrnvrate99                                         DECIMAL     (9,6)                                                     NOT NULL     /* （連携用）Ｖレート９９ */
)
;

ALTER TABLE ZT_Ratev2Rn_Z ADD CONSTRAINT PK_Ratev2Rn PRIMARY KEY (
     zrnhknsyukigou                                           , /* （連携用）保険種類記号 */
     zrnhknsyuruikigousedaikbn                                , /* （連携用）保険種類記号世代区分 */
     zrnyoteiriritu                                           , /* （連携用）予定利率 */
     zrnpmenkbn                                               , /* （連携用）Ｐ免区分 */
     zrnhrkkaisuukbn                                          , /* （連携用）払込回数区分 */
     zrnhhknsei                                               , /* （連携用）被保険者性別 */
     zrnkeiyakujihhknnen                                      , /* （連携用）契約時被保険者年令 */
     zrnsaimnkkykhyj                                          , /* （連携用）才満期契約表示 */
     zrnhknkkn                                                , /* （連携用）保険期間 */
     zrnphrkkikn                                              , /* （連携用）Ｐ払込期間 */
     zrnannaifuyouriyuukbn                                    , /* （連携用）案内不要理由区分 */
     zrntuukasyukbn                                           , /* （連携用）通貨種類区分 */
     zrndai1hknkkn                                              /* （連携用）第１保険期間 */
) ;
