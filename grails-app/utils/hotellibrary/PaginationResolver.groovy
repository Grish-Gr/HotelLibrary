package hotellibrary

class PaginationResolver {

    static List<Integer> getListAvailablePages(int currentPage, int countPages, int countAvailablePages){
        List<Integer> availablePages = new ArrayList<>()
        int countLeftPages = (countAvailablePages + 1) / 2
        if (currentPage < countLeftPages){
            for (int i = 0; i < countAvailablePages && i < countPages; i++){
                if (i < 0) continue
                availablePages.add(i + 1)
            }
            return availablePages
        }
        if (countPages - currentPage < countAvailablePages - 1){
            for (int i = countPages - countAvailablePages; i < countPages; i++){
                if (i < 0) continue
                availablePages.add(i + 1)
            }
            return availablePages
        }
        for (int i = currentPage - countLeftPages + 1; i < currentPage + countLeftPages && i < countPages; i++){
            if (i < 0) continue
            availablePages.add(i + 1)
        }
        return availablePages
    }
}
