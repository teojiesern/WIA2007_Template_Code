When working with Recycler view, we need to have view holder and adapter also together working as a
whole

# Recycler View

A view layout that displays a list of things dynamically

# View Holder

This is the holder of the view, essentially think of it like this, recycler view will have a big
number of views inside it and each of them is actually the view holder only, the recycler view
internally will recycle view meaning that let’s say the screen can only hold 4 views, when we scroll
pass the fourth, the first view holder will get recycled to be used by the fifth one again. There
are two important methods defined here which are

## Create

This is creating the view holder either because a new view is created or a view needs to be
recycled, we do not attach the view created here to the recycler view because like mentioned above,
this is just creating the view holder and it might be creating from scratch or creating using the
old view, which have old data. Therefore this is just creating a container, and then we would call
bind to bind the data to this container, then we attach it to the recycler view

## Bind

This is called after view is created. It gives back the instance of the view holder that is just
created and an integer position, this position can think of it as internally, Recycler view keeps a
dataset of the things that is added to the list using `submitList`, and it knows which position to
get which data now. Therefore we can leverage on

```
MoodNote current = getItem(position);
```

to get the data that we want which is the MoodNote object, consisting the data needed to update the
view that we just inflated.

# Adapter

This is like the lifecycle method of the data/domain layer of RecyclerView that we are leveraging
on. Basically when we use `submitList` we submitted the list into the dataset in the background
handled by RecyclerView, and we can declare the diffchecker in a sense in this adapter, telling
RecyclerViewAdapter how to check if something is different from each other, therefore indicating an
add, delete or update to the dataset, we can also overwrite the implementation
of `onCreateViewHolder` and `onBindViewHolder` here, basically the lifecycle things of how the
recyclerView works in the backend layer are all defined here

**Note** can have a look at practical 9 for MoodNote implementation