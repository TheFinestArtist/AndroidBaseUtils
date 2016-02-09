# AndroidBaseUtils
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-FinestWebView-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/2861)
[![Platform](https://img.shields.io/badge/platform-android-green.svg)](http://developer.android.com/index.html)
[![API](https://img.shields.io/badge/API-7%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=7)
[![License](https://img.shields.io/badge/License-MIT-blue.svg?style=flat)](http://opensource.org/licenses/MIT)

#### Context free and basic utils for building Android project

## ExtrasUtils
```java
public class SubActivity extends AppCompatActivity {

    public static final String EXTRA_TITLE = "EXTRA_TITLE";

    @Extra(EXTRA_TITLE) String title;
    @Extra ArrayList<Integer> ids;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ExtrasUtil.bind(this);
        // do something...
    }
}
```
```java
public class YourFragment extends Fragment {

    public static final String EXTRA_NAME = "EXTRA_NAME";
    
    @Extra(EXTRA_NAME) String name;
    
    @Nullable @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ExtrasUtil.bind(this);
        // do something...
    }
}
```

## License

```
The MIT License (MIT)

Copyright (c) 2016 TheFinestArtist

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
```