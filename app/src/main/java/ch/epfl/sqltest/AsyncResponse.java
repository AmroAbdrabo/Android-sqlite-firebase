package ch.epfl.sqltest;

import java.util.List;

interface AsyncResponse {
    void messageFetchFinished(List<String> output);
}
