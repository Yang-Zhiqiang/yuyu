CREATE TABLE ZT_RatewRn_Z (
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
     zrnwrate00                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート００ */
     zrnwrate01                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート０１ */
     zrnwrate02                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート０２ */
     zrnwrate03                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート０３ */
     zrnwrate04                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート０４ */
     zrnwrate05                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート０５ */
     zrnwrate06                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート０６ */
     zrnwrate07                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート０７ */
     zrnwrate08                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート０８ */
     zrnwrate09                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート０９ */
     zrnwrate10                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート１０ */
     zrnwrate11                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート１１ */
     zrnwrate12                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート１２ */
     zrnwrate13                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート１３ */
     zrnwrate14                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート１４ */
     zrnwrate15                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート１５ */
     zrnwrate16                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート１６ */
     zrnwrate17                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート１７ */
     zrnwrate18                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート１８ */
     zrnwrate19                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート１９ */
     zrnwrate20                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート２０ */
     zrnwrate21                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート２１ */
     zrnwrate22                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート２２ */
     zrnwrate23                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート２３ */
     zrnwrate24                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート２４ */
     zrnwrate25                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート２５ */
     zrnwrate26                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート２６ */
     zrnwrate27                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート２７ */
     zrnwrate28                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート２８ */
     zrnwrate29                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート２９ */
     zrnwrate30                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート３０ */
     zrnwrate31                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート３１ */
     zrnwrate32                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート３２ */
     zrnwrate33                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート３３ */
     zrnwrate34                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート３４ */
     zrnwrate35                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート３５ */
     zrnwrate36                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート３６ */
     zrnwrate37                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート３７ */
     zrnwrate38                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート３８ */
     zrnwrate39                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート３９ */
     zrnwrate40                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート４０ */
     zrnwrate41                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート４１ */
     zrnwrate42                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート４２ */
     zrnwrate43                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート４３ */
     zrnwrate44                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート４４ */
     zrnwrate45                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート４５ */
     zrnwrate46                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート４６ */
     zrnwrate47                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート４７ */
     zrnwrate48                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート４８ */
     zrnwrate49                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート４９ */
     zrnwrate50                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート５０ */
     zrnwrate51                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート５１ */
     zrnwrate52                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート５２ */
     zrnwrate53                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート５３ */
     zrnwrate54                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート５４ */
     zrnwrate55                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート５５ */
     zrnwrate56                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート５６ */
     zrnwrate57                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート５７ */
     zrnwrate58                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート５８ */
     zrnwrate59                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート５９ */
     zrnwrate60                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート６０ */
     zrnwrate61                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート６１ */
     zrnwrate62                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート６２ */
     zrnwrate63                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート６３ */
     zrnwrate64                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート６４ */
     zrnwrate65                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート６５ */
     zrnwrate66                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート６６ */
     zrnwrate67                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート６７ */
     zrnwrate68                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート６８ */
     zrnwrate69                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート６９ */
     zrnwrate70                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート７０ */
     zrnwrate71                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート７１ */
     zrnwrate72                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート７２ */
     zrnwrate73                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート７３ */
     zrnwrate74                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート７４ */
     zrnwrate75                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート７５ */
     zrnwrate76                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート７６ */
     zrnwrate77                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート７７ */
     zrnwrate78                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート７８ */
     zrnwrate79                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート７９ */
     zrnwrate80                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート８０ */
     zrnwrate81                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート８１ */
     zrnwrate82                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート８２ */
     zrnwrate83                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート８３ */
     zrnwrate84                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート８４ */
     zrnwrate85                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート８５ */
     zrnwrate86                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート８６ */
     zrnwrate87                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート８７ */
     zrnwrate88                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート８８ */
     zrnwrate89                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート８９ */
     zrnwrate90                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート９０ */
     zrnwrate91                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート９１ */
     zrnwrate92                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート９２ */
     zrnwrate93                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート９３ */
     zrnwrate94                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート９４ */
     zrnwrate95                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート９５ */
     zrnwrate96                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート９６ */
     zrnwrate97                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート９７ */
     zrnwrate98                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｗレート９８ */
     zrnwrate99                                         DECIMAL     (9,6)                                                     NOT NULL     /* （連携用）Ｗレート９９ */
)
;

ALTER TABLE ZT_RatewRn_Z ADD CONSTRAINT PK_RatewRn PRIMARY KEY (
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
